// written by 20200207 박연우

package com.example.hackathon07.domain;

import jakarta.persistence.*;

@Entity
@Getter @Setter
@Table(name = "Like")
public class Like {

    @Id @GeneratedValue
    @Column(name = "LIKE_ID")
    private Long like_id;

    @Column(name = "Like")
    private int like;

    /**
     * Like_ID (Pkey)가 현재 Users를 참조하고 있음. 어떻게 구현해야 할지 모르겠음.
     * */
    @ManyToOne   // 참조, 연관 관계 헷갈림. 우선 Like가 many가 되도록 설정함.
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Review_ID")
    private Review review;

    /**
     *  생성자 메소드
     * */

    public Like(int LIKE_ID, int like, Review review) {
        this.like_id = LIKE_ID;
        this.like = like;
        this.review = review;
    }

    /**
     * Getter Method 생성
     * */

    public int getLikeID() { return like_id; }

    public int getLike() { return like; }

    public int getReviewID() { return review; }

}