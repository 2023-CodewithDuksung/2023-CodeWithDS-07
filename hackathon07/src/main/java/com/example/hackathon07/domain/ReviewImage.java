// written by 20200207 박연우

package com.example.hackathon07.domain;

import jakarta.persistence.*;

@Entity
@Getter @Setter
@Table(name = "Review_Image")
public class ReviewImage {

    /**
     * field
     * */

    @ID @GeneratedValue
    @Column(name = "REVIEW_IMAGE_ID")
    private Long review_image_id;

    @ManyToOne
    @JoinColumn(name = "Menu_ID")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "Review_ID")
    private Review review;

    @Column(name = "Review_Image_URL")
    private String reviewImageURL;

    /**
     * 생성자 메소드
     */

    public ReviewImage(int reviewImageID, Menu menu, Review review, String reviewImageURL) {
        this.review_image_id = reviewImageID;
        this.menu = menu;
        this.review = review;
        this.reviewImageURL = reviewImageURL;
    }

    /**
     * Getter Method 생성
     * */

    public int getReviewImageID() { return review_image_id; }

    public Menu getMenuID() { return menu; }

    public Review getReviewID() { return review; }

    public String getReviewImageURL() { return reviewImageURL; }

}