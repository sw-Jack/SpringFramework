package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring3.MemberInfoPrinter;
import spring3.MemberPrinter;

@Configuration
public class ConfigPart2 {
	
	// 다른 파일에 있는 객체 정보를 가져와 주입할 수 있게 해줌
	// 첫번째 테스트
	// @Autowired	
	// private MemberDao memberDao;

	// 두번째 테스트
	@Autowired
	private ConfigPart1 configPart1;
	
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	 @Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		
		// 첫번째 테스트
		// memberInfoPrinter.setMemberDao(memberDao);
		// 두번째 테스트
		memberInfoPrinter.setMemberDao(configPart1.memberDao());
		
		memberInfoPrinter.setMemberPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
