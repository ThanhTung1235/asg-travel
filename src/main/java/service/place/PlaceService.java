package service.place;

import entity.Place;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PlaceService {
    @WebMethod
    String save(Place place);

    @WebMethod
    List<Place> getAll();

    @WebMethod
    Place getPlace(long id);
}
