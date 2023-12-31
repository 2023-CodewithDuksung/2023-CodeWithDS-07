package com.example.hackathon07.repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    // findById, Name을 사용할 때 값이 Null일 수 있기에 Null을 그대로 반환하지 않고 Optional로 감싸서 반환
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();

}
