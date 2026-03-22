package com.staredu.goyangii.service;


import com.staredu.goyangii.domain.Records;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecordsService {


    public static Long join(Records records) {
        return RecordsService.join(records);
    }
}
