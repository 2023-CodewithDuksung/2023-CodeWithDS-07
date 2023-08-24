// written by 20200207 PARK YEON WOO

package main.java.com.example.hackathon07.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon07.domain.Review;
import com.example.hackathon07.domain.ReviewRepository; // domain에 해당 클래스 아직 미생성
import main.java.com.example.hackathon07.dto.ReviewRequestDTO;
import main.java.com.example.hackathon07.dto.ReviewResponseDTO;
// import com.exception.CustomException;
// import com.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
    // field
    private final ReviewRepository reviewRepository;

    /**
     * review 콘텐츠 생성
     * '@Transitional'은 JPA를 사용한다면, service 클래스에서 필수적으로 사용되어야 함.
     * 메소드의 실행, 종료, 예외를 기준으로 각각 begin, commit, rollback을 자동 처리함.
     * */ 
    @Transactional 
    public Long save(final ReviewRequestDTO params) {
        Review entity = reviewRepository.save(params.toEntity());   // save 메소드 실행시 새로운 리뷰가 생성됨
        return entity.getReview_id();   // 메소드 종료 후, 생성된 리뷰의 id를 return함
    }

    /**
     * review 리스트 조회
     */
    public List<ReviewResponseDTO> findAll() {
        Sort sort = Sort.by(Direction.DESC, "review_id", "createdDate");  // sort 객체는 ORDER BY id DESC, created_date DESC을 의미
        List<Review> list = reviewRepository.findAll(sort);
        return list.stream().map(ReviewResponseDTO::new).collect(Collectors.toList());  // 자바의 stream API 이용
    }

    /**
     * review 수정
     */
    @Transactional
    public Long update(final Long review_id, final ReviewRequestDTO params) {
        Review entity = reviewRepository.findById(review_id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getMenu_id(), params.getReviewRating(), params.getContent(), params.getReviewEditedDateTime(), params.getReviewStatus());
        return review_id;
    }

}
