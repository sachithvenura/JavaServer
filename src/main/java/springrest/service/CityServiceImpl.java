package springrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrest.dao.CityDao;
import springrest.model.Cities;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	CityDao cityDao;

	@Autowired
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public List<Cities> listAllCities() {
		return this.cityDao.listAllCities();
	}

	public void addCity(Cities city) {
		this.cityDao.addCity(city);
	}

	public void updateCity(Cities city) {
		this.cityDao.updateCity(city);
	}

	public void deleteCity(Cities city) {
		this.cityDao.deleteCity(city);
	}

	public List<Cities> searchCity(String city) {
		return this.cityDao.searchCity(city);
	}

	public Cities findCity(Cities city) {
		return this.cityDao.findCity(city);
	}

}
