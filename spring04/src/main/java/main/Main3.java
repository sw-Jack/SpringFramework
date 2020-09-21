package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigPart1;
import config.ConfigPart2;
import config.ConfigPartMain;
import spring3.MemberInfoPrinter;
import spring3.MemberRegisterService;
import spring3.RegisterRequest;

// 이번엔 XML파일 활용하지 않고 자바 파일(config.JavaConfig) 자체 활용
public class Main3 {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(
						ConfigPartMain.class); 
		
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter memberInfoPrinter = 
				ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("a@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);
		
		memberInfoPrinter.printMemberInfo("a@naver.com");
	}
}
