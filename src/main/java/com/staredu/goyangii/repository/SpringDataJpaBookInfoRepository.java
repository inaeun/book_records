package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.BookInfo;
import com.staredu.goyangii.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaBookInfoRepository extends JpaRepository<BookInfo, Long>, BookInfoRepository {

    Optional<BookInfo> findByName(String name);
}
