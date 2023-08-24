package main.java.com.example.hackathon07.dto;

import java.io.File;

import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.Review;
import com.example.hackathon07.domain.ReviewImage;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewImageDTO {

    private Long review_image_id;
    private Menu menu_id;
    private Review review_id;
    private String reviewImageURL;

    public ReviewImage toEntity() {
        ReviewImage build = ReviewImage.builder()
                .review_image_id(review_image_id)
                .menu_id(menu_id)
                .review_id(review_id)
                .reviewImageURL(reviewImageURL)
                .build();
        return build;
    }

    @Builder
    public ReviewImageDTO(Long review_image_id, Menu menu_id, Review review_id, String reviewImageURL) {
        this.review_image_id = review_image_id;
        this.menu_id = menu_id;
        this.review_id = review_id;
        this.reviewImageURL = reviewImageURL;
    }
    
}
