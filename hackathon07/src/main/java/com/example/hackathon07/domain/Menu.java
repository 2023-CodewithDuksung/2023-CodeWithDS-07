package com.example.hackathon07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "Menu_Items")
public class Menu {
    @Id @GeneratedValue
    @Column(name = "Menu_ID")
    private Long menu_id;

    @OneToMany
    @JoinColumn(referencedColumnName = "Menu_Section_Id")
    private MenuSection menu_section_id;

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
    private int menu_tag_id;

//    public Menu(Long menu_id, MenuSection menu_section_id, String menuName, String menuDescription, String menuPhotoUrl, float menuStarRating, String menuPrice, int menu_tag_id) {
//        this.menu_id = menu_id;
//        this.menu_section_id = menu_section_id;
//        this.menuName = menuName;
//        this.menuDescription = menuDescription;
//        this.menuPhotoUrl = menuPhotoUrl;
//        this.menuStarRating = menuStarRating;
//        this.menuPrice = menuPrice;
//        this.menu_tag_id = menu_tag_id;
//    }
}
