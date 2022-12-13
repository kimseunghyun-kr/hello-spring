package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import domain.Member;
import repository.MemoryMemberRepository;

public class MemberServiceTest {

    MemoryMemberRepository repository;
    MemberService memberService;
    
    @BeforeEach
    public void BeforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() {
        //given
        Member newMember = new Member();
        newMember.setName("hello");
        //when
        Long saveId = memberService.join(newMember);
        //then
        Assertions.assertThat(memberService.findOne(saveId).get().getName()).isEqualTo(newMember.getName());
    }

    @Test
    void validateDuplicateMember() {
        //given
        Member newMember = new Member();
        newMember.setName("hello");
        //when
        Long saveId = memberService.join(newMember);
        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(newMember));
        Assertions.assertThat(e.getMessage()).isEqualTo("repeated ppl");
    }   

    @Test
    void testFindOne() {


    }

    @Test
    void testJoin() {

    }
}
