package springrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrest.dao.HotelDao;
import springrest.model.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	HotelDao hotelDao;
	
	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public List<Hotel> listAllHotels() {
		return this.hotelDao.listAllHotels();
	}

	public void addHotel(Hotel hotel) {
		this.hotelDao.addHotel(hotel);
	}

	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	public void deleteHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	public Hotel findHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelDao.findHotel(hotel);
	}

}
