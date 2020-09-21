package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring3.MemberInfoPrinter;
import spring3.MemberPrinter;
import spring3.MemberDao;
@Configuration
public class ConfigPartSub {
	
	@Autowired	
	private MemberDao memberDao;

	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	 @Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		

		memberInfoPrinter.setMemberDao(memberDao);

		memberInfoPrinter.setMemberPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
