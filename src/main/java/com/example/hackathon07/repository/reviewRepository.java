// written by 20200207 PARK YEON WOO

import main.java.com.example.hackathon07.repository;

import lombok.*;

// JPA Repository 인터페이스
@RequiredArgsConstructor
public interface reviewRepository {
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
