package dev.nich4545.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    // Look for movie with given imdbId then and connect the body to the found movie
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Using template to perform update call on the Movie class
        // where the imdbId received from the user matches the one in the db
        // will then push a new update to the reviewIds Array with the new reviewId (review)
        // To summarize: Used to populate the empty Array in the database (reviewIds) with the reviews
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
