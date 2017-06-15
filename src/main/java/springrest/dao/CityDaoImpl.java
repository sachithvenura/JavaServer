package springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springrest.model.Cities;

@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory factory;

    private Session getSession() {
        return factory.getCurrentSession();
    }

    public List<Cities> listAllCities() {
        return getSession().createCriteria(Cities.class).list();
    }

    @Transactional
    public void addCity(Cities city) {
        try {
            getSession().save(city);
        } catch (Exception e) {
            System.out.println("Err" + e.getMessage());
        }
    }

    @Transactional
    public void updateCity(Cities city) {
        try {
            getSession().saveOrUpdate(city);
        } catch (Exception e) {
            System.out.println("Err" + e.getMessage());
        }
    }

    @Transactional
    public void deleteCity(Cities city) {
        try {
            getSession().delete(city);
        } catch (Exception e) {
            System.out.println("Err" + e.getMessage());
        }
    }

    public Cities findCity(Cities city) {
        return (Cities) getSession().get(Cities.class, city.getCityId());
    }

    public List<Cities> searchCity(String city) {
        Criteria criteria = getSession().createCriteria(Cities.class)
                .add(Restrictions.like("cityName", "%" + city + "%"));
        return criteria.list();
    }

}
