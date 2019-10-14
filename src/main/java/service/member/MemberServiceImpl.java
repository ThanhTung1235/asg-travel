package service.member;

import com.google.gson.Gson;
import entity.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.List;

@WebService(endpointInterface = "service.member.MemberService")
public class MemberServiceImpl implements MemberService {
    @WebMethod
    public String save(Member member) {
        System.out.println(new Gson().toJson(member));
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Serializable a = session.save(member);
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
    public List<Member> getAll() {
        return HibernateUtil.getSession().createQuery("SELECT a FROM Member a", Member.class).getResultList();
    }

    public Member Authentication(String username, String password) {
//        HibernateUtil.getSession().createQuery("select a from Member a where name = :username", Member.class);
        return null;
    }


}
