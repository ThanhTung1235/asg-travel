package service.rating;

import com.google.gson.Gson;
import entity.Member;
import entity.Rating;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "service.rating.RatingService")
public class RatingServiceImpl implements RatingService {
    @WebMethod
    public String save(Rating rating) {
        System.out.println(new Gson().toJson(rating));
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(rating);
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
    public List<Rating> getAll() {
        return HibernateUtil.getSession().createQuery("SELECT a FROM Rating a", Rating.class).getResultList();
    }
}
