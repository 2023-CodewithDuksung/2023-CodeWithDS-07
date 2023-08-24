package com.example.hackathon07.repository.userrepository;
import com.example.hackathon07.domain.User;

import java.util.*;


public abstract class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setUser_id(++sequence);           // id 세팅
        store.put(user.getUser_id(), user);  // store에 저장 -> map에 저장
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        /**
         * 람다식 사용
         * 루프로 돌림
         * member.getName 이 parameter로 받은 name과 같은지 확인
         * 같은 경우에만 filtering
         * 결과는 Optional로 반환
         * 끝까지 루프 돌렸는데 없으면 Optional로 반환
         */

        return store.values().stream()
                .filter(user -> user.getUserName().equals(name))
                .findAny();
    }

    @Override
    public Optional<User> findByStudentNumber(int studentNumber) {
        return store.values().stream()
                .filter(user -> Integer.valueOf(user.getStudentNumber()).equals(studentNumber))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        /**
         * 실무에서 List를 많이 쓴다 -> 루프 돌리기 편함
         * store.values() : member
         */
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
