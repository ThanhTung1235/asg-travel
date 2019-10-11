package service.photo;

import entity.Member;
import entity.Photo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService()
public interface PhotoService {
    @WebMethod
    String save(Photo photo);

    @WebMethod
    List<Photo> getAll();
}
