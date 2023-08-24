package com.example.hackathon07.service;

import com.example.hackathon07.domain.User;
import com.example.hackathon07.dto.UserDTO;
import com.example.hackathon07.repository.userrepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할
public class UserService {
    private final UserRepository userRepository; // 먼저 jpa, mysql dependency 추가

    public void save(UserDTO userDTO) {
        // repository의 save 메서드 호출
        User user = User.toUser(userDTO);
        userRepository.save(user);
        //Repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)

    }

    public UserDTO login(UserDTO userDTO) {
        Optional<User> byStudentNumber = userRepository.findByStudentNumber(userDTO.getStudentNumber());
        if (byStudentNumber.isPresent()) {
            // 조회 결과가 있다
            User user = byStudentNumber.get(); // Optional에서 꺼냄
            if (user.getPasswordHash().equals(userDTO.getPasswordHash())) {
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                UserDTO dto = userDTO.toUserDTO(user);

                return dto;
            } else {
                //비밀번호 불일치
                return null;
            }
        } else {
            // 조회 결과가 없다
            return null;
        }
    }
}
