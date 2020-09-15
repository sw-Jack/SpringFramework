package sample;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
	
		// ** 싱글톤 패턴 
		// - 스프링은 별도로 설정하지 않으면 하나의 Bean객체만 생성
		// - 하나의 객체만을 생성하고 이후 사용하게 되면 참조만을 반환하게됨(추가적인 객체 생성X)
		// - 한번 생성된 객체는 여러 번 참조될 수 있지만 동시에 여러번 참조될 수는 없다.
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext3.xml");
		// 객체1 : g
		Greeter g = ctx.getBean("greeter1", Greeter.class);	
		String ret = g.greet("홍길동");
		System.out.println(ret);
		// 객체2 : g2
		Greeter g2 = ctx.getBean("greeter2", Greeter.class);
		ret = g2.greet("이순신");
		System.out.println(ret);
		
		System.out.println(g == g2); // 두 객체는 Greeter 클래스에 대한 서로 다른 객체임
		ctx.close(); // 항상 사용하고 난 뒤 종료해주어야 함
	}

}
