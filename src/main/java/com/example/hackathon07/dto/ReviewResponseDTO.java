// written by 20200207 PARK YEON WOO

package main.java.com.example.hackathon07.dto;

import java.time.LocalDateTime;

import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.Review;
import com.example.hackathon07.domain.User;

import lombok.Getter;

@Getter 
public class ReviewResponseDTO {
    
    // field
    private Long review_id;    // Pkey
    private User user_id;   // 유저 번호 (작성자)
    private Menu menu_id;   // 메뉴 번호 
    private float reviewRating;   // 메뉴에 대한 별점
    private String reviewContent;   // 리뷰 내용
    private LocalDateTime reviewCreaionDateTime;  // 생성 시각
    private LocalDateTime reviewEditedDateTime;   // 수정 시각
    private int reviewStatus;   // 리뷰 상태 (수정, 삭제 등)

    // 응답(Response) DTO 클래스 생성자 메소드
    public ReviewResponseDTO(Review entity) {
        this.review_id = entity.getReview_id();
        this.user_id = entity.getUser_id();
        this.menu_id = entity.getMenu_id();
        this.reviewRating = entity.getReviewRating();
        this.reviewContent = entity.getReviewContent();
        this.reviewCreaionDateTime = entity.getReviewCreaionDateTime();
        this.reviewEditedDateTime = entity.getReviewEditedDateTime();
    }

    // 
}
