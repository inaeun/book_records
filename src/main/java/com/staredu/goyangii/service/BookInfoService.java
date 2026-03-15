package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.repository.BookInfoRepository;
import com.staredu.goyangii.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookInfoService {

    private final MemberRepository memberRepository;
    private final BookInfoRepository bookInfoRepository;

    @Autowired
    public BookInfoService(MemberRepository memberRepository, BookInfoRepository bookInfoRepository) {
        this.memberRepository = memberRepository;
        this.bookInfoRepository = bookInfoRepository;
    }

    /**
     *책 정보 추가
     */
    public Long join(Bookinfo bookinfo) {

        validateDuplicateBookInfo(bookinfo);
        bookInfoRepository.save(bookinfo);

        return bookinfo.getId();
    }

    private void validateDuplicateBookInfo(Bookinfo bookInfo) {
        bookInfoRepository.findByBookname(bookInfo.getBookname())
                .ifPresent(b -> {
                    throw new IllegalStateException("이미 존재하는 도서입니다.");
                });
    }


    /**
     * 전체 책 조회
     */
    public List<Bookinfo> findBookinfo() {

        return bookInfoRepository.findAll();
    }

}
