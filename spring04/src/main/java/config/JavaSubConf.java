package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.MemberRegisterService;
import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
public class JavaSubConf {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean 
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}

}
