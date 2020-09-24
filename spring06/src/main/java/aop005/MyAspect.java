package aop005;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(* runSomething())")
	public void before(JoinPoint joinPoint) {
			System.out.println("(Before) 열쇠로 문을 열고 집에 들어간다.");
		}	
	@After("execution(* runSomething())")
	public void after(JoinPoint joinPoint) {
		System.out.println("(After) 문을 잠그고 외출한다.");
	}
}


