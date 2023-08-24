package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 다른 데 갖다 쓸 것이 아니기 때문에 public 삭제해도 됨
class MemoryMemberRepositoryTest {
    // 객체를 만든다.
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // save() 기능이 동작하는지 테스트
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        // repository에 member 저장
        repository.save(member);

        // 저장한 id 제대로 들어갔는지 검증, Optional 반환타입은 값을 꺼낼 때 get() 사용가능
        // get() 사용이 좋은 방법은 아니다
        // 똑같으면 참이된다
        Member result = repository.findByUser_id(member.getUser_id()).get();
        // System.out.println("result = " + (result == member));

        // assertions
        // 둘이 같은지 검증
        // Assertions.assertEquals(result, result);
        // 참이면 녹색불
        // 거짓이면 빨간 불이 들어옴 - 콘솔창은 아래와 같이
        // Expected : 기대값은 member
        // Actual : 실제로 들어온 값
        // Assertion을 static으로 지정하면 assertThat으로 바뀌어서 Assertion 없이 assertThat만으로 사용할 수 있다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setUserName("spring1");
        repository.save(member1);

        // 정교한 테스트를 위해 member2를 생성
        // shift + f6 으로 한꺼번에 이름 변경
        Member member2 = new Member();
        member2.setUserName("spring2");
        repository.save(member2);

        Member result = repository.findByUserName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setUserName("spring1");
        repository.save(member1);
        
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
