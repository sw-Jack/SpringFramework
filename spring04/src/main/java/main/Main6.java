package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

// 이번엔 XML파일 활용하지 않고 자바 파일(config.JavaConfig) 자체 활용
public class Main6 {
	public static void main(String[] args) {
		// GenericXmlApplicationContext 때와 동일하다고 보면 됨. 단지 XML 파일이냐 Java 파일이냐 차이.
		// AnnotationConfigApplicationContext는 가변 인자를 가지므로 설정 파일이 여러 개면 여러 개 나열해 주면됨
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:main-conf.xml");
		
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
