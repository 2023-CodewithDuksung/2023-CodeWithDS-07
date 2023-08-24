package com.example.hackathon07;

import com.example.hackathon07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class AppConfig {
    private DataSource dataSource;

    @Autowired
    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 스프링 빈을 등록한다.
     * 멤버 서비스 로직을 호출해서 스프링 빈에 등록
     */
    @Bean
    public UserService memberService() {
        return new UserService(userRepository()); // 멤버 리포지토리 넣어줘야
    }

    /**
     * MemberService(memberRepository());
     * 멤버 서비스와 멤버 리포지토리를 스프링 빈에 등록
     * 그러면서 스프링 빈에 등록돼있는 멤버 리포지토리를 멤버 서비스에 넣어줌
     * 스프링이 올라올 때, 흐름이 완성됨
     * 컨트롤러는 애노테이션을 놔둠
     */

    @Bean
    public UserRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
}
