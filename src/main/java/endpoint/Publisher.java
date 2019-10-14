package endpoint;

import service.city.CityServiceImpl;
import service.comment.CommentServiceImpl;
import service.district.DistrictServiceImpl;
import service.member.MemberServiceImpl;
import service.photo.PhotoServiceImpl;
import service.place.PlaceServiceImpl;
import service.rating.RatingServiceImpl;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
//        member
        Endpoint.publish("http://localhost:9000/member", new MemberServiceImpl());
//        place
        Endpoint.publish("http://localhost:9000/place", new PlaceServiceImpl());
//        comment
        Endpoint.publish("http://localhost:9000/comment", new CommentServiceImpl());
//        rating
        Endpoint.publish("http://localhost:9000/rating", new RatingServiceImpl());
//        photo
        Endpoint.publish("http://localhost:9000/photo", new PhotoServiceImpl());
//        city
        Endpoint.publish("http://localhost:9000/city", new CityServiceImpl());
//        district
        Endpoint.publish("http://localhost:9000/district", new DistrictServiceImpl());
    }
}
