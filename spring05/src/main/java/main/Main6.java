package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig6;
import spring.Client3;
import spring.Client5;

public class Main6 {
	public static void main(String[] args) {
		
			useXml();
			useJava();
	}
	
	static void useXml() {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx6.xml");
		Client3 client1 = ctx.getBean("client", Client3.class);
		Client3 client2 = ctx.getBean("client", Client3.class);

		System.out.println("xml : client1 != client2 => " + (client1 != client2));
		
		// prototype의 Bean은 스프링 컨테이너의 제어 범위 밖이므로 소멸에 사용되는 메서드를 직접 호출할 필요가 있다.
		client1.closeConnection();
		client2.closeConnection();
		ctx.close();
	}
	
	static void useJava() {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig6.class);
		Client5 client1 = ctx.getBean("client5", Client5.class);
		Client5 client2 = ctx.getBean("client5", Client5.class);

		System.out.println("xml : client1 != client2 => " + (client1 != client2));
		
		// prototype의 Bean은 스프링 컨테이너의 제어 범위 밖이므로 소멸에 사용되는 메서드를 직접 호출할 필요가 있다.
		client1.shutdown();
		client2.shutdown();
		ctx.close();
	}
}

