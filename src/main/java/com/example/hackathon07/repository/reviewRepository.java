import main.java.com.example.hackathon07.repository;

import lombok.*;

// JPA Repository 인터페이스
@RequiredArgsConstructor
public interface ReviewRepository {
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
