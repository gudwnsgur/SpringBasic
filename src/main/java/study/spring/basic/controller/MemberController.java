package study.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.basic.domain.Member;
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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

}
