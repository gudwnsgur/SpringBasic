package study.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.spring.basic.service.MemberService;


/*
    spring container에 객체가 생성돼서 spring이 관리한다.
    spring container에서 srevice를 가져와 하나만 등록
 */
@Controller
public class MemberController {
    // 1. 필드 주입
//    @Autowired  private MemberService memberService;

    // 2. 생성자 주입
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 3. setter 주입
    // 단점 : memberService 가 public 으로 노출
//    private MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
