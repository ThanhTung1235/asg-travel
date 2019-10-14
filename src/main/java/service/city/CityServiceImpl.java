package service.city;

import com.google.gson.Gson;
import entity.City;
import entity.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import java.util.List;

@WebService(endpointInterface = "service.city.CityService")
public class CityServiceImpl implements CityService {
    @WebMethod
    public List<City> getAll() {
        return HibernateUtil.getSession().createQuery("select  a from City a", City.class).getResultList();
    }

    public City getCity(long cityId) {
        Query query = HibernateUtil.getSession().createQuery("from City where mtp = :mtp ");
        query.setParameter("mtp", cityId);
        List<City> cities = query.getResultList();
        return cities.get(0);
    }
}


