package service.member;

import entity.Member;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService()
public interface MemberService {
    @WebMethod
    String save(Member member);

    @WebMethod
    List<Member> getAll();

    @WebMethod
    Member Authentication(String username, String password);

}
