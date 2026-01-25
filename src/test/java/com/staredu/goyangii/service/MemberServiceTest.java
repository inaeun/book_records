package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.Member;
import com.staredu.goyangii.repository.MemberRepository;
import com.staredu.goyangii.repository.MemoryMemberRepository;

import com.staredu.goyangii.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

class MemberServiceTest {

    //MemberService memberservice = new MemberService();
    //MemberRepository memberrepository = new MemoryMemberRepository();

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() throws Exception {

        //Given
        Member member = new Member();
        member.setName("Hello");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());

    }

    @Test
    void 중복_회원_예외() throws Exception {

        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);

//        try{
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo(expected "이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //Then
    }

    @Test
    void findOne() {}

}