package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.BookInfo;
import com.staredu.goyangii.domain.Member;
import com.staredu.goyangii.repository.BookInfoRepository;
import com.staredu.goyangii.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BookInfoService {

    private final BookInfoRepository bookInfoRepository;

    @Autowired
    public BookInfoService(BookInfoRepository bookInfoRepository) {
        this.bookInfoRepository = bookInfoRepository;
    }

    /**
     *책 정보 추가
     */
    public Long join(BookInfo bookInfo) {

        validateDuplicateBookInfo(bookInfo);
        bookInfoRepository.save(bookInfo);

        return bookInfo.getId();
    }

    private void validateDuplicateBookInfo(BookInfo bookInfo) {
        bookInfoRepository.findByName(bookInfo.getBookname())
                .ifPresent(b -> {
                    throw new IllegalStateException("이미 존재하는 책입니다.");
                });
    }


    /**
     * 전체 책 조회
     */
    public List<BookInfo> findBookInfo() {

        return bookInfoRepository.findAll();
    }

}
