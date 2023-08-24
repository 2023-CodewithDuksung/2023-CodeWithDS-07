package com.example.hackathon07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Table(name = "Reviews")
public class Review {

    /**
     * field
     */

    final int REVIEW_STATUS = 1;  // 리뷰 수정 상태 (-1: delete, 0: public, 1: updated)

    @Id @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long review_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "User_ID")
    private User user_id;  // fk 관계 생성, writer

    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_ID")
    private Menu menu_id;  // fk 관계 생성

    @Column(name = "Review_Rating")
    private float reviewRating;   // decimal(2,1)

    @Column(name = "Review_Content")
    private String reviewContent;   // text type

    @CreatedDate
    @Column(name = "Review_Creation_DateTime")
    private LocalDateTime reviewCreaionDateTime;  // dateTime type // .now() 사용 여부 논의 필요

    @LastModifiedDate
    @Column(name = "Review_Edited_DateTime")
    private LocalDateTime reviewEditedDateTime;   // dateTime type

    @Column(name = "Review_Status")
    private int reviewStatus;

    /**
     * 생성자 메소드
     */

    @Builder
    public Review(int review_id, User user_id, Menu menu_id, float reviewRating, String reviewContent, LocalDateTime reviewCreaionDateTime, LocalDateTime reviewEditedDateTime, int reviewStatus) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewCreaionDateTime = reviewCreaionDateTime;
        this.reviewEditedDateTime = reviewEditedDateTime;
        this.reviewStatus = reviewStatus;
    }

    // 리뷰 수정 기능 추가 (** 작성자 번호 수정 불가)
    public void update(Menu menu_id, float reviewRating, String reviewContent, LocalDateTime reviewEditedDateTime, int reviewStatus) {
        this.menu_id = menu_id;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewEditedDateTime = LocalDateTime.now();
        this.reviewStatus = 1;  // 1은 리뷰가 수정되었음(updated)을 의미함
    }

    // 리뷰 삭제 기능 추가
    public void delete() {
        this.reviewStatus = -1; // -1은 delete 이루어진 상태
    }

}