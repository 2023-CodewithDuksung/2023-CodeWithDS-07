package com.example.hackathon07.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Menu_Items")
public class Menu {
    @Id @GeneratedValue
    @Column(name = "Menu_ID")
    private Long menu_id;

    @OneToMany
    @JoinColumn(referencedColumnName = "Menu_Section_Id")
    private MenuSection menuSectionId;

    @Column(name = "Menu_Name")
    private String menuName;

    @Column(name = "Menu_Description")
    private String menuDescription;

    @Column(name = "Menu_Photo_URL")
    private String menuPhotoUrl;

    @Column(name = "Menu_Star_Rating")
    private float menuStarRating;

    @Column(name = "Menu_Price")
    private String menuPrice;

    @Column(name = "Menu_Tag_ID")
    private int menuTagId;

    public Menu(Long menu_id, MenuSection menuSectionId, String menuName, String menuDescription, String menuPhotoUrl, float menuStarRating, String menuPrice, int menuTagId) {
        this.menu_id = menu_id;
        this.menuSectionId = menuSectionId;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.menuPhotoUrl = menuPhotoUrl;
        this.menuStarRating = menuStarRating;
        this.menuPrice = menuPrice;
        this.menuTagId = menuTagId;
    }
}
