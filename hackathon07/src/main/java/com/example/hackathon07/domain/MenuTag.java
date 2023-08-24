package com.example.hackathon07.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "Menu_Tag")

public class MenuTag {
    @Id @GeneratedValue
    @Column(name = "MENU_TAG_ID")
    private Long menuTagId;

    @Column(name = "Menu_Tag_Name")
    private String menuTagName;

    public MenuTag(Long menuTagId, String menuTagName) {
        this.menuTagId = menuTagId;
        this.menuTagName = menuTagName;
    }

}