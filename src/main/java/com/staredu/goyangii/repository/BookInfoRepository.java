package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.Bookinfo;

import java.util.List;
import java.util.Optional;

public interface BookInfoRepository {

    Bookinfo save(Bookinfo bookinfo);
    Optional<Bookinfo> findById(Long id);
    Optional<Bookinfo> findByBookname(String bookname);
    List<Bookinfo> findAll();
}
