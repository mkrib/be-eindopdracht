package nl.novi.beeindopdracht.controllers;

import jakarta.validation.Valid;
import nl.novi.beeindopdracht.dtos.ReviewDto;
import nl.novi.beeindopdracht.dtos.ReviewRequestDto;
import nl.novi.beeindopdracht.entities.Review;
import nl.novi.beeindopdracht.mappers.ReviewMapper;
import nl.novi.beeindopdracht.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        List<ReviewDto> reviewDtos = reviewMapper.translateToDtos(reviews);

        return ResponseEntity.ok().body(reviewDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReview(id));
    }

    @PostMapping("")
    public ResponseEntity<ReviewDto> addReview(@Valid @RequestBody ReviewRequestDto reviewRequestDto) {
        Review postedReview = reviewService.addReview(reviewMapper.translateToReview(reviewRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewMapper.translateToDto(postedReview));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }




}
