package service.district;

import com.google.gson.Gson;
import entity.City;
import entity.Comment;
import entity.District;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import java.util.List;

@WebService(endpointInterface = "service.district.DistrictService")
public class DistrictServiceImpl implements DistrictService {
    public List<District> getByCityId(long cityId) {
        Query query = HibernateUtil.getSession().createQuery("from District where mtp = :mtp ");
        query.setParameter("mtp", cityId);
        return query.getResultList();
    }
    public District getDistrict(long districtId) {
        Query query = HibernateUtil.getSession().createQuery("from District where maqh = :maqh ");
        query.setParameter("maqh", districtId);
        List<District> districts = query.getResultList();
        return districts.get(0);
    }
}
