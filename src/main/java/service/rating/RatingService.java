package service.rating;

import entity.Member;
import entity.Rating;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService()
public interface RatingService {
    @WebMethod
    String save(Rating rating);

    @WebMethod
    List<Rating> getAll();
}
