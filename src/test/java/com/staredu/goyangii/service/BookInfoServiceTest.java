package com.staredu.goyangii.service;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.domain.Records;
import com.staredu.goyangii.repository.BookInfoRepository;
import com.staredu.goyangii.repository.RecordsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional

@SpringBootTest
class BookInfoServiceTest {

    @Autowired
    BookInfoService bookInfoService;

    @Autowired
    BookInfoRepository bookInfoRepository;

    @Autowired
    RecordsService  recordsService;

    @Autowired
    RecordsRepository recordsRepository;



    @Test
    void 책_등록() throws Exception {

        //Given
        Bookinfo bookInfo = new Bookinfo();
        bookInfo.setBookname("Hello");

        //When
        Long saveId = bookInfoService.join(bookInfo);

        //Then
        Bookinfo findBookInfo = bookInfoRepository.findById(saveId).get();
        assertThat(findBookInfo.getBookname()).isEqualTo(bookInfo.getBookname());

    }

    @Test
    void 중복_책_예외() throws Exception {

        //Given
        Bookinfo bookInfo1 = new Bookinfo();
        bookInfo1.setBookname("spring");

        Bookinfo bookInfo2 = new Bookinfo();
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

    @Test
    void 기록_등록() throws Exception {

        //Given
        Records records = new Records();
        records.setDate(new Date());
        records.setPages(0);
        records.setInspirations("");

        //When
        Long saveId = recordsService.join(records);

        //Then
        //작업 필요!!!
        Records findRecords = recordsRepository.findById(saveId).get();
        assertThat(findRecords.getDate()).isEqualTo(records.getDate());

    }


}