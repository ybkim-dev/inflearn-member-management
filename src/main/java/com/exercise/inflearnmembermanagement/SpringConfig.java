package com.exercise.inflearnmembermanagement;

import com.exercise.inflearnmembermanagement.repository.MemberRepository;
import com.exercise.inflearnmembermanagement.repository.MemoryMemberRepository;
import com.exercise.inflearnmembermanagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
