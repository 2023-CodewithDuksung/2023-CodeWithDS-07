package com.example.hackathon07.dto;

import com.example.hackathon07.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private Long user_id;
    private String userName;
    private String passwordHash;
    private int studentNumber;
    private int level;

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setUserName(user.getUserName());
        userDTO.setStudentNumber(user.getStudentNumber());

        return userDTO;
    }


}
