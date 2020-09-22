package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig;
import spring.Client3;

public class Main4 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		System.out.println("스프링 컨테이너 생성 완료!");
		Client3 client = ctx.getBean("client3", Client3.class);
		client.send();
		ctx.close(); 
	}
}
