package com.example.hackathon07.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Review_Image")
public class ReviewImage {

    /**
     * field
     * */

    @Id @GeneratedValue
    @Column(name = "REVIEW_IMAGE_ID")
    private Long review_image_id;

    @ManyToOne
    @JoinColumn(name = "Menu_ID")
    private Menu menu_id;

    @ManyToOne
    @JoinColumn(name = "Review_ID")
    private Review review_id;

    @Column(name = "Review_Image_URL")
    private String reviewImageURL;

    /**
     * 생성자 메소드
     */

    public ReviewImage(int review_image_id, Menu menu_id, Review review_id, String reviewImageURL) {
        this.review_image_id = review_image_id;
        this.menu_id = menu_id;
        this.review_id = review_id;
        this.reviewImageURL = reviewImageURL;
    }


}