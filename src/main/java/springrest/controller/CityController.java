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
import org.springframework.web.servlet.ModelAndView;

import springrest.model.Cities;
import springrest.service.CityService;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("/city")
    public ModelAndView cityList() {//Welcome page, non-rest
        ModelAndView model = new ModelAndView("city/list");
        Cities c = new Cities();
        c.setCityName("Lavinia");
        List<Cities> list = cityService.listAllCities();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping("/city/list")
    public ResponseEntity<List<Cities>> getcityList() {
        List<Cities> list = cityService.listAllCities();
        System.out.println(list.size());
        if (list.isEmpty()) {
            return new ResponseEntity<List<Cities>>(HttpStatus.CREATED);
        }
        return new ResponseEntity<List<Cities>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/city/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addCity(@RequestBody Cities cities) {
        cityService.addCity(cities);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Cities> findCityById(@PathVariable("id") Integer id) {
        Cities search = new Cities();
        search.setCityId(id);
        Cities list = cityService.findCity(search);
        return new ResponseEntity<Cities>(list, HttpStatus.OK);
    }

    @RequestMapping("/city/search/{query}")
    public ResponseEntity<List<Cities>> searchCityList(@PathVariable("query") String query) {
        List<Cities> list = cityService.searchCity(query);
        System.out.println(list.size());
        if (list.isEmpty()) {
            return new ResponseEntity<List<Cities>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cities>>(list, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/city/update/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> updateCity(@RequestBody Cities cities) {
//        cityService.updateCity(cities);
        System.out.println("updated=====================================================================");
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }
}
