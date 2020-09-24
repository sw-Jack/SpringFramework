package aop012;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Pointcut("execution(* runSomething())")
	private void pntct() {}
	
	@Before("pntct()")
	public void before(JoinPoint joinPoint) {
		System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}	
	
	@After("pntct()")
	public void after(JoinPoint joinPoint) {
		System.out.println("외출 : 문을 잠궈라");
	}
	
	@Around("pntct()")
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
	
	// 핵심 기능 정상 실행 이후 
	@AfterReturning("pntct()")
	public void afterReturning(JoinPoint jp) {
		System.out.println("핵심 기능 정상 종료 : 하루를 반성해라 ㅋㅋㅋㅋ");
	}

}


