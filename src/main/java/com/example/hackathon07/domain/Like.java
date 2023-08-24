package com.example.hackathon07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@Table(name = "Like")
public class Like {

    @Id @GeneratedValue
    @Column(name = "LIKE_ID")
    private Long like_id;

    @Column(name = "Like")
    private int like;

    /**
     * Like_ID (Pkey)가 현재 Users를 참조하고 있음. 어떻게 구현해야 할지 모르겠음.
     **/
    @ManyToOne   // 참조, 연관 관계 헷갈림. 우선 Like가 many가 되도록 설정함.
    @JoinColumn(name = "USER_ID")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "Review_ID")
    private Review review_id;

    /**
     * 생성자 메소드
     **/

    public Like(Long like_id, int like, Review review_id) {
        this.like_id = like_id;
        this.like = like;
        this.review_id = review_id;
    }

    /**
     * Getter Method 생성
     **/

    public Long getLikeID() { return like_id; }

    public int getLike() { return like; }

    public Review getReviewID() { return review_id; }

}