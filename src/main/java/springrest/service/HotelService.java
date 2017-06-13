package springrest.service;

import java.util.List;

import springrest.model.Hotel;

public interface HotelService {
	public List<Hotel> listAllHotels();

	public void addHotel(Hotel hotel);

	public void updateHotel(Hotel hotel);

	public void deleteHotel(Hotel hotel);

	public Hotel findHotel(Hotel hotel);
	
	public List<Hotel> searchHotel(String query);
}
