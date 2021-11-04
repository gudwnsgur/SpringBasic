package study.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.spring.basic.service.MemberService;


/*
    spring container에 객체가 생성돼서 spring이 관리한다.
 */
@Controller
public class MemberController {
    // private final MemberService memberService = new MemberService();

    // spring container에서 srevice를 가져와 하나만 등록
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
