package hello.hellospring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "Users")
@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "User_ID")
    private Long user_id;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "Password_Hash")
    private String passwordHash;

    @Column(name = "Student_Number")
    private Integer studentNumber;

    @Column(name = "Level")
    private Integer level;
}
