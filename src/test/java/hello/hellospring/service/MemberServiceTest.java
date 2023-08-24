package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberService;

    // new로 다른 객체 repository(memberRepository)가 생성됨
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        // test 실행할 때마다 생성
        // MemoryMemberRepository를 만들고 memberService에 넣는다.
        // 같은 MemoryMemberRepository가 사용된다.
        // DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    /**
     * test는 한글로 작성해도 된다!
     */

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}