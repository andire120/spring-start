package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.cleatStore();
    }

    @Test
        void 회원가입() {
            //given
            Member member = new Member();
            member.setName("hello");

            //when
            long saveId = memberService.join(member);

            //then
            Member findMember = memberService.findOne(saveId).get(); //ctrl + alt + v
            assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        Long saveId = memberService.join(member1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertThat(e.getMessage().isEqualTo("이미 존재하는 회원입니다."));
/*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage().equals("이미 존재하는 회원입니다."));
        }
*/

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}