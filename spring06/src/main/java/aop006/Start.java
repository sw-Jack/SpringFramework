package aop006;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop006.xml");

		Person romeo = ctx.getBean("boy", Person.class);
		romeo.runSomething();
		
	}
}
