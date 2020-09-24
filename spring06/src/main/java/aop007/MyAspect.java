package aop007;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	

	public void before(JoinPoint joinPoint) {
		System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}	
	
	public void after(JoinPoint joinPoint) {
		System.out.println("외출 : 문을 잠궈라");
	}
}


