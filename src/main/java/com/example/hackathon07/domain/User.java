package com.example.hackathon07.domain;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private Long user_id;
    
    private String userName;
    private String passwordHash;
    private int studentNumber;
    private int level;

    public User(int userID, String userName, String passwordHash, int studentNumber, int level) {
        this.userID = userID;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.studentNumber = studentNumber;
        this.level = level;
    }

    /**
     * Getter method 생성
     */

    public int getUserID() {
        return userID;
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
