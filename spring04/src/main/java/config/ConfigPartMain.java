package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring3.MemberRegisterService;
import spring3.MemberDao;

@Configuration
@Import(ConfigPartSub.class) // 다른 클래스를 포함하도록 선언 // ConfigPartMain이 불리면 ConfigPartSub도 함께 불림
public class ConfigPartMain {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
