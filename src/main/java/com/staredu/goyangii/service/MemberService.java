package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.Member;
import com.staredu.goyangii.repository.BookInfoRepository;
import com.staredu.goyangii.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final BookInfoRepository bookInfoRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, BookInfoRepository bookInfoRepository) {
        this.memberRepository = memberRepository;
        this.bookInfoRepository = bookInfoRepository;
    }

    /**
     *회원가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    /**
     * 회원 일련번호 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
