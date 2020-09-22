package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client1;
import spring.Client2;
import spring.Client3;

public class Main2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new
				GenericXmlApplicationContext("classpath:appctx2.xml");
		System.out.println("스프링 컨테이너 생성 완료!");
		Client2 client = ctx.getBean("client", Client2.class);
		client.send();
		ctx.close(); // Bean 객체 종료 및 소멸자 실행
	}
}
