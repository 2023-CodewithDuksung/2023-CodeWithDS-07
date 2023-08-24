// written by 20200207 PARK YEON WOO

package main.java.com.example.hackathon07.dto;

import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.Review;
import com.example.hackathon07.domain.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRequestDTO {
    
    // field
    private Long review_id; // 리뷰 번호
    private User user_id;   // 유저 번호 fkey (writer)
    private Menu menu_id;   // 메뉴 번호 fkey
    private String content; // 리뷰 내용
    private float reviewRating; // 메뉴에 대한 사용자의 별점
    private int reviewStatus;     // 상태 (수정, 삭제 등의 여부)

    // 요청(Request) DTO 클래스 생성자 메소드
    public Review toEntity() {
        return Review.builder()
                    .review_id(review_id)
                    .user_id(user_id)
                    .menu_id(menu_id)
                    .reviewRating(reviewRating)
                    .reviewContent(content)
                    .reviewStatus(reviewStatus)
                    .build();

    }

}
