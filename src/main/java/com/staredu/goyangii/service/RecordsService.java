package com.staredu.goyangii.service;


import com.staredu.goyangii.domain.Records;
import com.staredu.goyangii.repository.MemberRepository;
import com.staredu.goyangii.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordsService {

    private final MemberRepository memberRepository;
    private final RecordsRepository recordsRepository;

    @Autowired
    public RecordsService(MemberRepository memberRepository, RecordsRepository recordsRepository) {
        this.memberRepository = memberRepository;
        this.recordsRepository = recordsRepository;
    }

    /**
     * 기록 추가
     */
    public Long join(Records records) {

        //validateDuplicateRecords(records);
        recordsRepository.save(records);
        return records.getId();


    }

    /**
     * 전체 기록 조회
     */
    public List<Records> findRecords() {

        return recordsRepository.findAll();
    }

//    private void validateDuplicateRecords(Records records) {
//        recordsRepository.findByDate(records.getInspirations())
//
//    }
}
