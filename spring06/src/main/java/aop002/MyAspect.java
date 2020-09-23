package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect	// 이 클래스는 AOP에서 사용할 관점이다. 공통(횡단) 관심 기능이 들어 있다.
public class MyAspect {
	
	// 핵심 기능 '전' 공통 기능으로 동작할 메서드
	// public void aop002.Boy.runsomething() 실행 전 사용하겠다.
	//@Before("execution(public void aop002.Boy.runSomething()) ||"
	//		+ "execution(public void aop002.Girl.runSomething())")
	@Before("execution(public void aop002.*.runSomething())")	// Pointcut : 자르고 들어갈 지점/기준,
	public void before(JoinPoint joinPoint) {	// 매개 변수 -> runSomething() 실행 시점을 참조하는 메서드
			System.out.println("열쇠로 문을 열고 집에 들어간다.");
		}	// before 메서드 자체가 Advice(조언)
}


