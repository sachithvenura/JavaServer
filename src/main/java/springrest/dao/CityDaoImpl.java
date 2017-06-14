package springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springrest.config.NewHibernateUtil;

import springrest.model.Cities;

@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory factory;

    Session s = NewHibernateUtil.getSessionFactory().openSession();

    private Session getSession() {
        return factory.getCurrentSession();
    }

//	@SuppressWarnings("unchecked")
    public List<Cities> listAllCities() {
            return s.createCriteria(Cities.class).list();
    }

    public void addCity(Cities city) {
        Transaction t = s.beginTransaction();
        try {
            s.save(city);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            System.out.println("Err" + e.getMessage());
        }
    }

    public void updateCity(Cities city) {
        Transaction t = s.beginTransaction();
        try {
            getSession().saveOrUpdate(city);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            System.out.println("Err" + e.getMessage());
        }
    }

    public void deleteCity(Cities city) {
        Transaction t = s.beginTransaction();
        try {
            getSession().delete(city);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            System.out.println("Err" + e.getMessage());
        }
    }

    public Cities findCity(Cities city) {
        return (Cities) s.get(Cities.class, city.getCityId());
    }

    @SuppressWarnings("unchecked")
    public List<Cities> searchCity(String city) {
        Criteria criteria = s.createCriteria(Cities.class)
                .add(Restrictions.like("cityName", "%" + city + "%"));
        return criteria.list();
    }

}
