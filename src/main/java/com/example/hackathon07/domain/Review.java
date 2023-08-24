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

    @Id @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long review_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "User_ID")
    private User user_id;  // fk 관계 생성

    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_ID")
    private Menu menu_id;  // fk 관계 생성

    @Column(name = "Review_Rating")
    private float reviewRating;   // decimal(2,1)

    @Column(name = "Review_Content")
    private String reviewContent;   // text type

    @CreatedDate
    @Column(name = "Review_Creation_DateTime")
    private LocalDateTime reviewCreaionDateTime;  // dateTime type

    @LastModifiedDate
    @Column(name = "Review_Edited_DateTime")
    private LocalDateTime reviewEditedDateTime;   // dateTime type

    @Column(name = "Review_Status")
    private int reviewStatus;

    /**
     * 생성자 메소드
     */

    public Review(int reviewID, User userID, Menu menuID, float reviewRating, String reviewContent, LocalDateTime reviewCreaionDateTime, LocalDateTime reviewEditedDateTime, int reviewStatus) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewCreaionDateTime = reviewCreaionDateTime;
        this.reviewEditedDateTime = reviewEditedDateTime;
        this.reviewStatus = reviewStatus;
    }
}