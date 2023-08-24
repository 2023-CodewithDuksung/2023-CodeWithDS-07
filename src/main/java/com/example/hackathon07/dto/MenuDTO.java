package com.example.hackathon07.dto;

import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.MenuSection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MenuDTO {

    private Long menu_id;
    private MenuSection menu_section_id;
    private String menuName;
    private String menuDescription;
    private String menuPhotoUrl;
    private float menuStarRating;
    private String menuPrice;
    private int menu_tag_id;

    public static MenuDTO toMemberDTO(Menu menu){
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenu_id(menu.getMenu_id());
        menuDTO.setMenuName(menu.getMenuName());
        menuDTO.setMenuDescription(menu.getMenuDescription());
        menuDTO.setMenuPhotoUrl(menu.getMenuPhotoUrl());
        menuDTO.setMenuStarRating(menu.getMenuStarRating());
        menuDTO.setMenuPrice(menu.getMenuPrice());

        return menuDTO;
    }
}
