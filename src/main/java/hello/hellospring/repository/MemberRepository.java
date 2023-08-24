package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByUser_id(Long user_id);
    Optional<Member> findByUserName(String userName);

    boolean authenticate(Integer studentNumber, String password);

    List<Member> findAll();
    Optional<Member> findByStudentNumber(Integer studentNumber);
}
