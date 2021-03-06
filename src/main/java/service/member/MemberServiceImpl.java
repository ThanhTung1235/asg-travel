package service.member;

import com.google.gson.Gson;
import entity.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
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

    @WebMethod
    public Member Authentication(String username, String password) {
        Query query = HibernateUtil.getSession().createQuery("from Member where name = :name ");
        query.setParameter("name", username);
        List<Member> list = query.getResultList();
        Member member = list.get(0);
        if (member == null) return null;
        else {
            if (member.getPassword().equals(password)){
                return member;
            } else  return null;

            }
    }


}
