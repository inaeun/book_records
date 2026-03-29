package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.domain.Records;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RecordsRepository {

    Records save(Records records);
    Optional<Records> findById(Long id);
//    Optional<Records> findByBookname(String bookname);
    Optional<Records> findByDate(Date date);
    List<Records> findAll();
}
