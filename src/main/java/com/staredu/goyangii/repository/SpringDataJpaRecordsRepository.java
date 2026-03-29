package com.staredu.goyangii.repository;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.domain.Records;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRecordsRepository extends JpaRepository<Records, Long>, RecordsRepository {

    Optional<Records> findById(Long id);
}
