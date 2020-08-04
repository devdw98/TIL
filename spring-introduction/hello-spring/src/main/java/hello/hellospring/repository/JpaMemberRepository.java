package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //jpa는 이것으로 모든 걸 동작함
    //gradle에서 jpa 설정이 있으면 springboot에서 자동으로 만들어준다
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);//영구 저장하다
        return member;
    }

    //pk기반이 아닌 것들은 jpql을 작성해주어야 함
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //jpql
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
        .setParameter("name",name)
        .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //jpql : 엔티티 대상으로 쿼리 날림
        List<Member> result =  em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}
