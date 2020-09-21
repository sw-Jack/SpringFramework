package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig {
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
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		memberInfoPrinter.setMemberDao(memberDao());
		memberInfoPrinter.setMemberPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
