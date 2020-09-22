package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client1;
import spring.Client3;

public class Main3 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new
				GenericXmlApplicationContext("classpath:appctx3.xml");
		System.out.println("스프링 컨테이너 생성 완료!");
		Client3 client = ctx.getBean("client", Client3.class);
		client.send();
		ctx.close(); 
	}
}
