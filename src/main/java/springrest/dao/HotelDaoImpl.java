package springrest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springrest.model.Hotel;

@Repository
public class HotelDaoImpl implements HotelDao{
	
	
//	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	
//	@Autowired
//	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//	}
	
	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> listAllHotels() {
//		List<Hotel> list=new ArrayList<Hotel>();
//		String sql="select * from hotels";
//		list=namedParameterJdbcTemplate.query(sql, getParameterSource(null),new HotelMapper());
//		return list;
		
		return (List<Hotel>)getSession().createCriteria(Hotel.class).list();
	}

	public void addHotel(Hotel hotel) {
//		String sql="Inser into hotels(hotel_name,hotel_description,hotel_image,hotel_ratings) values (:hotelName,:hotelDescription,:hotelImage,:hotelRatings)";
//		namedParameterJdbcTemplate.update(sql, getParameterSource(hotel));
		getSession().saveOrUpdate(hotel);
		
	}

	public void updateHotel(Hotel hotel) {
		getSession().saveOrUpdate(hotel);
		
	}

	public void deleteHotel(Hotel hotel) {
		getSession().delete(hotel);
		
	}

	public Hotel findHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return (Hotel) getSession().get(Hotel.class, hotel.getId());
	}

	public List<Hotel> searchHotel(String query) {
		Criteria criteria = getSession().createCriteria(Hotel.class)
				   .add(Restrictions.like("hotelName", "%"+query+"%"));
		return criteria.list();
	}
	
//	public SqlParameterSource getParameterSource(Hotel hotel) {
//		MapSqlParameterSource source=new MapSqlParameterSource();
//		if (hotel!=null) {
//			source.addValue("hotel_name", hotel.getHotelName());
//		}
//		return source;
//	}
//	
//	private static final class HotelMapper implements RowMapper<Hotel>{
//		public Hotel mapRow(ResultSet rs,int row) throws SQLException{
//			Hotel hotel= new Hotel();
//			return hotel;
//		}
//	}

}
