package springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springrest.model.Hotel;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> listAllHotels() {
		return (List<Hotel>) getSession().createCriteria(Hotel.class).list();
	}

	public void addHotel(Hotel hotel) {
		getSession().saveOrUpdate(hotel);
	}

	public void updateHotel(Hotel hotel) {
		getSession().saveOrUpdate(hotel);
	}

	public void deleteHotel(Hotel hotel) {
		getSession().delete(hotel);
	}

	public Hotel findHotel(Hotel hotel) {
		return (Hotel) getSession().get(Hotel.class, hotel.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> searchHotel(String query) {
		Criteria criteria = getSession().createCriteria(Hotel.class)
				.add(Restrictions.like("hotelName", "%" + query + "%"));
		return criteria.list();
	}
}
