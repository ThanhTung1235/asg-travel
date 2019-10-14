package service.city;

import entity.City;
import entity.Comment;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CityService {
    @WebMethod
    List<City> getAll();

    @WebMethod
    City getCity(long cityId);

}
