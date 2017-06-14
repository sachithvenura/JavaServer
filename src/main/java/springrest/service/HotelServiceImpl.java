package springrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrest.dao.HotelDao;
import springrest.model.Hotels;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	HotelDao hotelDao;
	
	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public List<Hotels> listAllHotels() {
		return this.hotelDao.listAllHotels();
	}

	public void addHotel(Hotels hotel) {
		this.hotelDao.addHotel(hotel);
	}

	public void updateHotel(Hotels hotel) {
		this.hotelDao.updateHotel(hotel);
	}

	public void deleteHotel(Hotels hotel) {
		this.hotelDao.deleteHotel(hotel);
	}

	public Hotels findHotel(Hotels hotel) {
		return hotelDao.findHotel(hotel);
	}

	public List<Hotels> searchHotel(String query) {
		return hotelDao.searchHotel(query);
	}

}
