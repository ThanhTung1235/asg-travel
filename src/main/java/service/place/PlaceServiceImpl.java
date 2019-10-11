package service.place;

import com.google.gson.Gson;
import entity.Place;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "service.place.PlaceService")
public class PlaceServiceImpl implements PlaceService {
    @WebMethod
    public String save(Place place) {
        System.out.println(new Gson().toJson(place));
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(place);
            transaction.commit();
            return "save success!";
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return "save fail!";
        } finally {
            session.close();
        }
    }

    @WebMethod
    public List<Place> getAll() {
        return HibernateUtil.getSession().createQuery("select  a from Place a", Place.class).getResultList();
    }

    @WebMethod
    public Place getPlace(long id) {
        return HibernateUtil.getSession().get(Place.class, id);
    }
}
