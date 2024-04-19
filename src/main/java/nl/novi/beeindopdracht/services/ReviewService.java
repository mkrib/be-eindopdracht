package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.entities.Review;
import nl.novi.beeindopdracht.exceptions.RecordNotFoundException;
import nl.novi.beeindopdracht.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

//    TODO user repository linken wanneer aangemaakt

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //    GET
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Review not found"));
    }

    //    POST
    public Review addReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    //    DELETE
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
