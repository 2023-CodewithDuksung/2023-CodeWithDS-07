package com.example.hackathon07.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Menu_Items_Menu_Tag")
public class MenuItemsMenuTag {
    @Id @GeneratedValue
    @Column(name = "Menu_Items_Menu_Tag_ID")
    private Long menuItemsMenuTagId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_ID")
    private Menu menuId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_Tag_ID")
    private MenuTag menuTagId;


    public MenuItemsMenuTag(Long menuItemsMenuTagId, Menu menuId, MenuTag menuTagId) {
        this.menuItemsMenuTagId = menuItemsMenuTagId;
        this.menuId = menuId;
        this.menuTagId = menuTagId;
    }
}