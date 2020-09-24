package aop004;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// POJO 클래스 : 순수 자바 클래스 
public class MyAspect {
	

	public void before(JoinPoint joinPoint) {
		/*
		 * JoinPoint는 공통 기능이 실행되는 시점(메서드, pointcut)을 참조하는 변수
		 * @Before에서 execution으로 선언된 메서드(runSomething() 메서드)
		 */
			System.out.println("열쇠로 문을 열고 집에 들어간다.");
		}	
	
	public void after(JoinPoint joinPoint) {
		System.out.println("외출 : 문을 잠궈라");
	}
}


