package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.Bookinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaBookInfoRepository extends JpaRepository<Bookinfo, Long>, BookInfoRepository {

    Optional<Bookinfo> findByBookname(String bookname);
}
