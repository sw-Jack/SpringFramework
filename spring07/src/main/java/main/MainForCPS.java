package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword("0928183411@test.com", "1234", "4321");
			System.out.println("비밀번호 변경 완료");
		} catch(MemberNotFoundException e) {
			System.out.println("회원정보가 존재하지 않음");
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("비밀번호가 일치하지 않음");
		}
	}

}
