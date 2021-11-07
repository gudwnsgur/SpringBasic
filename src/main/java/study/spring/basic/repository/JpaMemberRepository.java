package study.spring.basic.repository;

import study.spring.basic.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // JPA는 EntityManager로 모든게 동작한다.
    // 내부적으로 DataSource를 들고있어서 DB와의 연동을 다 해결해준다.
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // setId() 까지 지원
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // JPQL : Entity를 대상으로 SQL문 작성
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }
}
