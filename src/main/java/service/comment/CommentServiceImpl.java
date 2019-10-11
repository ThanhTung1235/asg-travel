package service.comment;

import com.google.gson.Gson;
import entity.Comment;
import entity.Place;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.List;

@WebService(endpointInterface = "service.comment.CommentService")
public class CommentServiceImpl implements CommentService {
    @WebMethod
    public String save(Comment comment) {
        System.out.println(new Gson().toJson(comment));
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(comment);
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
    public List<Comment> getAll() {
        return HibernateUtil.getSession().createQuery("select  a from Comment a", Comment.class).getResultList();
    }

    @WebMethod
    public Comment getComment(long id) {
        return HibernateUtil.getSession().get(Comment.class, id);
    }
}
