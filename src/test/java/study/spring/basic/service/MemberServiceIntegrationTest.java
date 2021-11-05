package study.spring.basic.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.spring.basic.domain.Member;
import study.spring.basic.repository.MemberRepository;
import study.spring.basic.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
@Transactional  // TC에 있으면 Rollback 지원
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository MemberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("Spring");
        member2.setName("Spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->
                memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}