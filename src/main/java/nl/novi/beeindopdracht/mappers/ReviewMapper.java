package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.ReviewDto;
import nl.novi.beeindopdracht.dtos.ReviewRequestDto;
import nl.novi.beeindopdracht.entities.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapper {

    //    Mapper om de review om te zetten naar een dto, die we willen teruggeven aan de gebruiker
    public ReviewDto translateToDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setFullName(review.getFullName());
        dto.setContent(review.getContent());
        dto.setIssueDate(review.getIssueDate());
        dto.setUser(review.getUser());

        return dto;
    }

    public List<ReviewDto> translateToDtos(List<Review> reviewsList) {
        List<ReviewDto> result = new ArrayList<>();
        for (Review review : reviewsList) {
            result.add(translateToDto(review));
        }
        return result;
    }

    //    Mapper om de request review om te zetten naar een review voor in de db
    public Review translateToReview(ReviewRequestDto dto) {
        Review review = new Review();

        review.setFullName(dto.getFullName());
        review.setContent(dto.getContent());
        review.setIssueDate(dto.getIssueDate());
        review.setUser(dto.getUser());

        return review;
    }

}
