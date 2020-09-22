package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig5;
import spring.Client5;

public class Main5 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig5.class);
		System.out.println("스프링 컨테이너 생성 완료!");
		Client5 client = ctx.getBean("client5", Client5.class);
		client.send();
		ctx.close(); 
	}
}
