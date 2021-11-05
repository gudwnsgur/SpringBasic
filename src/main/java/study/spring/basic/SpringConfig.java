package study.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring.basic.repository.JdbcMemberRepository;
import study.spring.basic.repository.MemberRepository;
import study.spring.basic.repository.MemoryMemberRepository;
import study.spring.basic.service.MemberService;

import javax.sql.DataSource;

/*
 DI 두번 째 방법 : 자바 코드로 직접 스프링 빈 등록하기
 상황에 따라 구현 클래스를 변경하더라도 다른 코드를 건드리지 않고 변경할 수 있다.
 */
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // DB 사용 X
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}