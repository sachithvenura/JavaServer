package springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springrest.model.Hotel;
import springrest.service.HotelService;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "welcome";
    }
	
	@RequestMapping(value="/hotel/add",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> addHotel(@RequestBody Hotel hotel){
		hotelService.addHotel(hotel);
		return new ResponseEntity<Void>(new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/hotel",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Hotel>> listAllHotel(){
		List<Hotel> list= hotelService.listAllHotels();
		if (list.size()==0) {
			return new ResponseEntity<List<Hotel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hotel>>(list,HttpStatus.OK);
	}
	@RequestMapping(value="/hotel/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Hotel> findHotelById(@PathVariable("id") Integer id){
		Hotel search= new Hotel();
		search.setId(id);
		Hotel list= hotelService.findHotel(search);
		return new ResponseEntity<Hotel>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/hotel/search/{query}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Hotel>> searchHotel(@PathVariable("query") String query){
		List<Hotel> list= hotelService.searchHotel(query);
		if (list.size()==0) {
			return new ResponseEntity<List<Hotel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hotel>>(list,HttpStatus.OK);
	}
	@RequestMapping(value="/hotel/delete/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Void> deleteHotel(@PathVariable("id") Integer id){
		Hotel search= new Hotel();
		search.setId(id);
		hotelService.deleteHotel(search);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/hotel/update",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> updateHotel(@RequestBody Hotel hotel){
		hotelService.updateHotel(hotel);
		return new ResponseEntity<Void>(new HttpHeaders(),HttpStatus.CREATED);
	}
}
