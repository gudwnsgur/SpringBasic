package study.spring.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.basic.domain.Member;

import java.util.Optional;


// 인터페이스가 인터페이스를 받을땐 extends
public interface SpringDataJpaMemberRepository
        extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);

}
