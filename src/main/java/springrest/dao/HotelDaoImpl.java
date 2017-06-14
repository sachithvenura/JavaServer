package springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springrest.config.NewHibernateUtil;

import springrest.model.Hotels;

@Repository
public class HotelDaoImpl implements HotelDao {

    Session s = NewHibernateUtil.getSessionFactory().openSession();

    @SuppressWarnings("unchecked")
    public List<Hotels> listAllHotels() {
        List<Hotels> list = s.createCriteria(Hotels.class).list();
        return list;
    }

    public void addHotel(Hotels hotel) {
        Transaction t = s.beginTransaction();
        try {
            s.save(hotel);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    public void updateHotel(Hotels hotel) {
        s.saveOrUpdate(hotel);
    }

    public void deleteHotel(Hotels hotel) {
        s.delete(hotel);
    }

    public Hotels findHotel(Hotels hotel) {
        return (Hotels) s.get(Hotels.class, hotel.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Hotels> searchHotel(String query) {
        Criteria criteria = s.createCriteria(Hotels.class)
                .add(Restrictions.like("hotelName", "%" + query + "%"));
        return criteria.list();
    }
}
