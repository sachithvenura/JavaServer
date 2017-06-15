package springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springrest.model.Hotels;

@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    private SessionFactory factory;

    private Session getSession() {
        return factory.getCurrentSession();
    }

    public List<Hotels> listAllHotels() {
        List<Hotels> list = getSession().createCriteria(Hotels.class).list();
        return list;
    }

    @Transactional
    public void addHotel(Hotels hotel) {
        try {
            getSession().save(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateHotel(Hotels hotel) {
        getSession().saveOrUpdate(hotel);
    }

    @Transactional
    public void deleteHotel(Hotels hotel) {
        getSession().delete(hotel);
    }

    public Hotels findHotel(Hotels hotel) {
        return (Hotels) getSession().get(Hotels.class, hotel.getId());
    }

    public List<Hotels> searchHotel(String query) {
        Criteria criteria = getSession().createCriteria(Hotels.class);
        Disjunction disCriteria = Restrictions.disjunction();
        disCriteria.add(Restrictions.like("hotelName", "%" + query + "%"));
        disCriteria.add(Restrictions.like("hotelAddress", "%" + query + "%"));
        System.out.println(criteria.list().size());
        return criteria.add(disCriteria).list();
    }
}
