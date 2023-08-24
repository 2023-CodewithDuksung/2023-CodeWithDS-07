package com.example.hackathon07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "Menu_Section")
public class MenuSection {
    @Id @GeneratedValue
    @Column(name = "Menu_Section_ID")
    private Long menu_section_id;

    @Column(name = "Menu_Section_Name")
    private String menu_section_name;
}
