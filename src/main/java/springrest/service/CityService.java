package springrest.service;

import java.util.List;

import springrest.model.Cities;

public interface CityService {
	public List<Cities> listAllCities();

	public void addCity(Cities city);

	public void updateCity(Cities city);

	public void deleteCity(Cities city);

	public Cities findCity(Cities city);

	public List<Cities> searchCity(String city);
}
