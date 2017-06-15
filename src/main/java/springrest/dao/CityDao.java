package springrest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import springrest.model.Cities;

public interface CityDao {

    @JsonIgnore
    public List<Cities> listAllCities();

    public void addCity(Cities city);

    public void updateCity(Cities city);

    public void deleteCity(Cities city);

    @JsonIgnore
    public List<Cities> searchCity(String city);

    public Cities findCity(Cities city);
}
