package aop003;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// POJO 클래스 : 순수 자바 클래스 
public class MyAspect {
	
	public void before(JoinPoint joinPoint) {
			System.out.println("열쇠로 문을 열고 집에 들어간다.");
		}	
}


