package spring3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext3.xml");
		
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
