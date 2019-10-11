package endpoint;

import service.comment.CommentServiceImpl;
import service.member.MemberServiceImpl;
import service.photo.PhotoServiceImpl;
import service.place.PlaceServiceImpl;
import service.rating.RatingServiceImpl;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
//        member
        Endpoint.publish("http://localhost:8080/member", new MemberServiceImpl());
//        place
        Endpoint.publish("http://localhost:8080/place", new PlaceServiceImpl());
//        comment
        Endpoint.publish("http://localhost:8080/comment", new CommentServiceImpl());
//        rating
        Endpoint.publish("http://localhost:8080/rating", new RatingServiceImpl());
//        photo
        Endpoint.publish("http://localhost:8080/photo", new PhotoServiceImpl());
    }
}
