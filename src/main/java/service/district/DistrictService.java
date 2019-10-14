package service.district;

import entity.Comment;
import entity.District;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface DistrictService {
    @WebMethod
    List<District> getByCityId(long cityId);

    @WebMethod
    District getDistrict(long cityId);
}
