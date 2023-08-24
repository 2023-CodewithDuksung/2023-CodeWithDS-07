package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getUser_id();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUserName(member.getUserName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long user_id) {
        return memberRepository.findByUser_id(user_id);
    }

    public boolean authenticate(Integer studentNumber, String password) {
        Optional<Member> memberOptional = memberRepository.findByStudentNumber(studentNumber);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return passwordEncoder.matches(password, member.getPasswordHash());
        }
        return false;
    }
}
