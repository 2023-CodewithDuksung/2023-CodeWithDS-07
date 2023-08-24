package com.example.hackathon07.domain;

import com.example.hackathon07.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Users")
public class User {
    @Id @GeneratedValue
    @Column(name = "User_ID")
    private Long user_id;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "Password_Hash")
    private String passwordHash;

    @Column(name = "Student_Number")
    private int studentNumber;

    @Column(name = "Level")
    private int level;

//    public User(Long user_id, String userName, String passwordHash, int studentNumber, int level) {
//        this.user_id = user_id;
//        this.userName = userName;
//        this.passwordHash = passwordHash;
//        this.studentNumber = studentNumber;
//        this.level = level;
//    }

    public static User toUser(UserDTO userDTO){
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setUserName(userDTO.getUserName());
        user.setStudentNumber(userDTO.getStudentNumber());
        user.setPasswordHash(userDTO.getPasswordHash());

        userDTO.setUser_id(user.getUser_id());
        userDTO.setUserName(user.getUserName());
        userDTO.setStudentNumber(user.getStudentNumber());

        return user;
    }
}
