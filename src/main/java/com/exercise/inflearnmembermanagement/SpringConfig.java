package com.exercise.inflearnmembermanagement;

import com.exercise.inflearnmembermanagement.repository.JdbcMemberRepository;
import com.exercise.inflearnmembermanagement.repository.MemberRepository;
import com.exercise.inflearnmembermanagement.repository.MemoryMemberRepository;
import com.exercise.inflearnmembermanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
