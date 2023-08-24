package com.example.hackathon07.domain;

import jakarta.persistence.*;

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

    public User(Long user_id, String userName, String passwordHash, int studentNumber, int level) {
        this.user_id = user_id;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.studentNumber = studentNumber;
        this.level = level;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public int getLevel() {
        return level;
    }
}
