package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.MemberRepository;
import repository.MemoryMemberRepository;
import service.MemberService;


//a different DI method
//making spring beans directly without componentscan

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}