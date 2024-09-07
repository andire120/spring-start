package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPOL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);

}
