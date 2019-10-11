package service.photo;

import com.google.gson.Gson;
import entity.Member;
import entity.Photo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "service.photo.PhotoService")
public class PhotoServiceImpl implements PhotoService {
    @WebMethod
    public String save(Photo photo) {
        System.out.println(new Gson().toJson(photo));
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(photo);
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
    public List<Photo> getAll() {
        return HibernateUtil.getSession().createQuery("SELECT a FROM Photo a", Photo.class).getResultList();
    }
}
