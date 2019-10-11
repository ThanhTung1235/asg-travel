package service.comment;

import entity.Comment;
import entity.Place;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CommentService {
    @WebMethod
    String save(Comment comment);

    @WebMethod
    List<Comment> getAll();

    @WebMethod
    Comment getComment(long id);
}
