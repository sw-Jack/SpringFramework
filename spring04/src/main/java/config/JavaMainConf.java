package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.MemberRegisterService;
import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
@ImportResource("classpath:sub-conf.xml") // 자바 설정 파일(메인)에 XML설정 파일(서브) 추가
public class JavaMainConf {
	
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
