// written by 20200207 박연우
// 다른 테이블들의 클래스-컬럼명을 어떻게 지정했는지 다시 확인하여 매칭 시켜야 함

package com.example.hackathon07.domain;

import jakarta.persistence.*;

@Entity
@Getter @Setter
@Table(name = "Reviews")
public class Review {

    /**
     * field
     * */

    @Id @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long review_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "User_ID")
    private User user;  // fk 관계 생성

    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_ID")
    private Menu menu;  // fk 관계 생성

    @Column(name = "Review_Rating")
    private reviewRating;   // decimal(2,1)

    @Column(name = "Review_Content")
    private String reviewContent;   // text type

    @Column(name = "Review_Creation_DateTime")
    private reviewCreaionDateTime;  // dateTime type

    @Column(name = "Review_Edited_DateTime")
    private reviewEditedDateTime;   // dateTime type

    @Column(name = "Review_Status")
    private int reviewStatus;

    /**
     * 생성자 메소드
     */

    public Review(int reviewID, User userID, Menu menuID, reviewRating, String reviewContent, reviewCreationDateTime, reviewEditedDateTime, int reviewStatus)
        this.review_id = reviewID;
        this.user = userID;
        this.menu = menuID;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewCreationDateTime = reviewCreationDateTime;
        this.reviewEditedDateTime = reviewEditedDateTime;
        this.reviewStatus = reviewStatus;

    /**
     * Getter method 생성
     * */

    public int getReviewID() {
        return reviewID;
    }

    public int getUserID() { return userID; }

    public int getMenuId() {
        return menuId;
    }

    public getReviewRating() { return reviewRating; }   // type 미지정

    public String getReviewContent() {
        return reviewContent;
    }

    public getReviewCreationDateTime() { return reviewCreationDateTime;}    // type 미지정

    public getreviewEditedDateTime() { return reviewEditedDateTime;}    // type 미지정

    public int getReviewStatus() {
        return reviewStatus;
    }

}