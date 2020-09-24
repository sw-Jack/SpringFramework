package aop006;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	// 포인트컷 지시자를 미리 설정해두는 것 // 변수 생성과 같은 개념이라 생각
	@Pointcut("execution(* runSomething())")
	private void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
			System.out.println("(Before) 열쇠로 문을 열고 집에 들어간다.");
		}	
	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("(After) 문을 잠그고 외출한다.");
	}
}


