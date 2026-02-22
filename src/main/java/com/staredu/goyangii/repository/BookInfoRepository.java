package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.bookinfo;

import java.util.List;
import java.util.Optional;

public interface BookInfoRepository {

    bookinfo save(bookinfo bookinfo);
    Optional<bookinfo> findById(Long id);
    Optional<bookinfo> findByBookname(String bookname);
    List<bookinfo> findAll();
}
