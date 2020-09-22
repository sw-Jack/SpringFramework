package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client1;

public class Main1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new
				GenericXmlApplicationContext("classpath:appctx1.xml");
		System.out.println("스프링 컨테이너 생성 완료!");
		Client1 client = ctx.getBean("client", Client1.class);
		client.send();
		ctx.close();
	}
}
