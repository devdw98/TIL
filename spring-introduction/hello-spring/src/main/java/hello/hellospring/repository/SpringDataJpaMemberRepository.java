package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //spring-jpa가 jpaRepository를 받고 있으면
    // 구현체를 자동으로 만들어줘서 spring bean에 자동으로 등록한다
    // -> 가져다 쓰면 된다.

    //인터페이스 이름으로 개발이 끝난다!
    // JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);

}
