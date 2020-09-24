package aop008;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	

	public void before(JoinPoint joinPoint) {
		System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}	
	
	public void after(JoinPoint joinPoint) {
		System.out.println("외출 : 문을 잠궈라");
	}
	
	public void around(ProceedingJoinPoint pjp) {
		// ProceedingJointPoint : 핵심 기능을 호출하는 기능을 가지고 있음 (around 사용 시 필수)
		// Before
		System.out.println("옷을 갈아입는다.");
		
		try {
			pjp.proceed();	// 핵심 기능 호출 (하는 시점) // delegate.factorial(30); 과 같은 의미 
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// After
		System.out.println("씻는다.");
	}
}


