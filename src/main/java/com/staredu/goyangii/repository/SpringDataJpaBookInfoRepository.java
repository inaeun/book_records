package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.bookinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaBookInfoRepository extends JpaRepository<bookinfo, Long>, BookInfoRepository {

    Optional<bookinfo> findByBookname(String bookname);
}
