package springrest.dao;

import java.util.List;

import springrest.model.Hotels;

public interface HotelDao {

    public List<Hotels> listAllHotels();

    public void addHotel(Hotels hotel);

    public void updateHotel(Hotels hotel);

    public void deleteHotel(Hotels hotel);

    public Hotels findHotel(Hotels hotel);

    public List<Hotels> searchHotel(String query);
}
