package springrest.dao;

import java.util.List;

import springrest.model.Hotel;

public interface HotelDao {
	public List<Hotel> listAllHotels();

	public void addHotel(Hotel hotel);

	public void updateHotel(Hotel hotel);

	public void deleteHotel(Hotel hotel);

	public Hotel findHotel(Hotel hotel);
}
