package springrest.dao;

import java.util.List;

import springrest.model.Cities;

public interface CityDao {
	public List<Cities> listAllCities();

	public void addCity(Cities city);

	public void updateCity(Cities city);

	public void deleteCity(Cities city);
	
	public List<Cities> searchCity(String city);
	
	public Cities findCity(Cities city);
}
