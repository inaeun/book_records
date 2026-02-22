package com.staredu.goyangii;

import com.staredu.goyangii.repository.*;
import com.staredu.goyangii.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    //private final EntityManager em;

//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    private final MemberRepository memberRepository;
    private final BookInfoRepository bookInfoRepository;

    public SpringConfig(MemberRepository memberRepository, BookInfoRepository bookInfoRepository) {
        this.memberRepository = memberRepository;
        this.bookInfoRepository = bookInfoRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository, bookInfoRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
