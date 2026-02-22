package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.bookinfo;
import com.staredu.goyangii.repository.BookInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional

@SpringBootTest
class BookInfoServiceTest {

    @Autowired
    BookInfoService bookInfoService;

    @Autowired
    BookInfoRepository bookInfoRepository;



    @Test
    void 책_등록() throws Exception {

        //Given
        bookinfo bookInfo = new bookinfo();
        bookInfo.setBookname("Hello");

        //When
        Long saveId = bookInfoService.join(bookInfo);

        //Then
        bookinfo findBookInfo = bookInfoRepository.findById(saveId).get();
        assertThat(findBookInfo.getBookname()).isEqualTo(bookInfo.getBookname());

    }

    @Test
    void 중복_책_예외() throws Exception {

        //Given
        bookinfo bookInfo1 = new bookinfo();
        bookInfo1.setBookname("spring");

        bookinfo bookInfo2 = new bookinfo();
        bookInfo2.setBookname("spring");

        //When
        bookInfoService.join(bookInfo1);

//        try{
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo(expected "이미 존재하는 도서입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> bookInfoService.join(bookInfo2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 도서입니다.");

        //Then
    }


}