package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 스프링 테스트 할 때, 아래 어노테이션 필수
 * Transactional 붙이는 이유 : test를 실행할 때, 트랜젝션을 먼저 실행
 * DB 데이터 insert query -> test 끝나면 롤백함
 * test는 반복해서 실행하는 것이 중요함
 */
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    /**
     * 테스트할 때, 필드 기반으로 Autowired
     */
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    /**
     * 직접 객체를 만드는 것이 아니라,
     * 스프링 컨테이너한테 멤버 리포지토리, 멤버 서비스 얻어와야 함
     */

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");
        /**
         * 회원가입() test 했을 때, 오류나는 이유
         * DB에 "spring"이 존재해서
         * DB에서 delete 시켜줘야 함
         * delete 후 : spring이 뜬다
         * test가 끝나면 spring이 내려감
         */

        //when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // member2를 join할 시 예외가 발생
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
//        }

        // then
    }
}