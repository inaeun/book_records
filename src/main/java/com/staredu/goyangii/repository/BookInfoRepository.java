package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.BookInfo;
import com.staredu.goyangii.domain.Member;

import java.util.List;
import java.util.Optional;

public interface BookInfoRepository {

    BookInfo save(BookInfo bookinfo);
    Optional<BookInfo> findById(Long id);
    Optional<BookInfo> findByName(String bookname);
    List<BookInfo> findAll();
}
