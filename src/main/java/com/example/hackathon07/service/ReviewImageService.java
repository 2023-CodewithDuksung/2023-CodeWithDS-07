package main.java.com.example.hackathon07.service;

import java.io.File;

import main.java.com.example.hackathon07.domain.ReviewImage;
import main.java.com.example.hackathon07.dto.ReviewImageDTO;
import main.java.com.example.hackathon07.repository.ReviewImageRepository;

public class ReviewImageService {
    private ReviewImageRepository reviewImageRepository;

    public ReviewImageService(ReviewImageRepository reviewImageRepository) {
        this.reviewImageRepository = reviewImageRepository;
    }

    @Transactional
    public Long saveFile(ReviewImageDTO reviewImageDTO) {
        return reviewImageRepository.save(reviewImageDTO.toEntity()).getId();
    }

    @Transactional
    public ReviewImageDTO getFile(Long review_image_id) {
        ReviewImage reviewImage = reviewImageRepository.findById(review_image_id).get();

        ReviewImageDTO reviewImageDTO = ReviewImageDTO.builder()
                .review_image_id(review_image_id)
                .menu_id(reviewImage.getMenu_id())
                .review_id(reviewImage.getReview_id())
                .reviewImageURL(reviewImage.getReviewImageURL())
                .build();
        return reviewImageDTO;
    }
    
}
