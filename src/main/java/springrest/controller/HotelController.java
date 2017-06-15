package springrest.controller;

//import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.springframework.web.servlet.ModelAndView;
import springrest.model.Cities;
import springrest.model.Hotels;
import springrest.service.CityService;
import springrest.service.HotelService;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    CityService cityService;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "welcome";
    }

    @RequestMapping(value = "/hotel/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addHotel(@RequestBody Hotels hotel) {
        hotelService.addHotel(hotel);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping("/hotel")
    public ModelAndView hotelList() {//Welcome page, non-rest
        ModelAndView model = new ModelAndView("hotel/list");
        List<Hotels> list = hotelService.listAllHotels();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value = "/hotel/add2", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addHotel2(@RequestBody ObjectNode json) {
        Hotels hotel = new Hotels();
        hotel.setHotelName(json.get("hotel").get("hotelName").toString());
        hotel.setHotelAddress(json.get("hotel").get("hotelAddress").toString());
        Cities ct = new Cities();
        ct.setCityId(json.get("city").get("cityId").asInt());
        Cities cities = cityService.findCity(ct);
        hotel.setCities(cities);
        hotelService.addHotel(hotel);
        String output="success";
        return new ResponseEntity<String>(output,new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/list", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Hotels>> listAllHotel() {
        List<Hotels> list = hotelService.listAllHotels();
        System.out.println(list.size());
        for (Hotels hotels : list) {
            System.out.println(hotels.getHotelName());
        }
        return new ResponseEntity<List<Hotels>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Hotels> findHotelById(@PathVariable("id") Integer id) {
        Hotels search = new Hotels();
        search.setId(id);
        Hotels list = hotelService.findHotel(search);
        return new ResponseEntity<Hotels>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/search/{query}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Hotels>> searchHotel(@PathVariable("query") String query) {
        List<Hotels> list = hotelService.searchHotel(query);
        if (list.size() == 0) {
            return new ResponseEntity<List<Hotels>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Hotels>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") Integer id) {
        Hotels search = new Hotels();
        search.setId(id);
        hotelService.deleteHotel(search);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/update", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> updateHotel(@RequestBody ObjectNode json) {
        Hotels hotel = new Hotels();
        hotel.setId(json.get("hotel").get("hotelId").asInt());
        hotel.setHotelName(json.get("hotel").get("hotelName").textValue().toString().replaceAll("\"", ""));
        hotel.setHotelAddress(json.get("hotel").get("hotelAddress").textValue().toString().replaceAll("\"", ""));
        Cities ct = new Cities();
        ct.setCityId(json.get("city").get("cityId").asInt());
        Cities cities = cityService.findCity(ct);
        hotel.setCities(cities);
        hotelService.updateHotel(hotel);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }
}
