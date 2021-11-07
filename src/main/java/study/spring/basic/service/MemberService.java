package study.spring.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.basic.domain.Member;
import study.spring.basic.repository.MemberRepository;
import study.spring.basic.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional  // JPA 사용시 주의
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            // 같은 이름이 있는 중복 회원 X
            validateDuplicateMember(member);  // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    // 중복 회원 검증 Method
    private void validateDuplicateMember(Member member) {
        long start = System.currentTimeMillis();
        try {
            memberRepository.findByName(member.getName())
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
