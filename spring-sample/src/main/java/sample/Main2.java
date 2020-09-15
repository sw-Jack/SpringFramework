package sample;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		// 그냥 할 때와 Spring을 사용할 때의 차이
/*
		Greeter g = new Greeter();
		g.setFormat("%s님. 안녕하세요.");
		String ret = g.greet("홍길동");
		System.out.println(ret);
*/
		
		// xml 설정 파일을 읽어 들여 객체를 관리하는 컨테이너 객체 (컨테이너 : 객체 관리)
		// 프레임워크 특징 : 제어의 역흐름 -> 객체를 관리 제어하는 작업을 개발자가 하는 것이 아니라 프레임워크가 자동으로 한다.
		GenericXmlApplicationContext ctx = 
				// classpath -> 기본적으로 scr/main/resources 로 잡힘 
				// 그 위치에 applicatonContext.xml 파일의 정보를 읽어들임
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter g = ctx.getBean("greeter", Greeter.class);	
		String ret = g.greet("홍길동");
		System.out.println(ret);
		
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		ret = g2.greet("이순신");
		System.out.println(ret);
		
		System.out.println(g == g2);	// g와 ,g2는 Greeter 클래스에 대한 동일한 객체로 취급/인식
		ctx.close(); // 항상 사용하고 난 뒤 종료해주어야 함
	}

}
