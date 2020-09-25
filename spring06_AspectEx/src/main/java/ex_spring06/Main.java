package ex_spring06;


import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:execTime.xml");
		Calculator implCal = ctx.getBean("implCal", Calculator.class); // 상위 인터페이스 부르기***
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		
		// Calculator implCal = ctx.getBean("implCal", ImplCalculator.class);
		// Calculator recCal = ctx.getBean("recCal", RecCalculator.class);
		/*
		 * AOP가 적용될 객체가 인터페이스를 구현하고 있는 경우
		 * 프록시 객체가 생성될 때 해당 인터페이스를 구현하도록 요구된다.
		 * 만약 인터페이스를 이용하지 않고 프록시 객체를 생성하고자 하는 하는 경우 다음과 같은 설정이 필요하다.
		 * (1) XML 설정 : <aop:aspectj-autoproxy proxy-target-class="true"/>
		 * (2) JAVA 설정 : 
		 * 		@Configuration
		 * 		@EnableAspectJAutoProxy(proxyTargetClass=ture)
		 * - 위의 설정이 들어가면 스프링 AOP에서 프록시 객체를 해당 클래스를 상속하여 생성한다.

		 */
	    long n1 = implCal.fact(20); System.out.println(n1);
	    long n2 = recCal.fact(20);   System.out.println(n2);
	}
}
