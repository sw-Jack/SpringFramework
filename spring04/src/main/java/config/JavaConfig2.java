package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring2.MemberDao;
import spring2.MemberPrinter;
import spring2.MemberInfoPrinter;
import spring2.MemberRegisterService;

@Configuration
public class JavaConfig2 {
	// Factory 패턴
	@Bean	// 객체 한번 생성하게 되면 이후 호출할 때마다 객체를 계속 생성하지 말고  한번 생성한 시점에서 가져다 사용
	public MemberDao memberDao() {
		return new MemberDao();		// 객체 생성 반환
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	 @Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	 @Bean
	public MemberInfoPrinter memberInfoPrinter() {
		return new MemberInfoPrinter();
	}
}
