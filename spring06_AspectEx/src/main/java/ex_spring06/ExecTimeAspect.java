package ex_spring06;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)	// ExecTimeAspect는 0번
public class ExecTimeAspect{

	@Around("execution(public * fact(long))")
	public Object timeCalculator(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.nanoTime();
	    Object result = null;
	    try {
	    	// proceed()는 '객체'를 반환 **
	       result = pjp.proceed(); // fact() - 핵심 메서드(기능)
	    } finally {
	       long end = System.nanoTime();
	       System.out.printf("%s.fact(%s) 수행 시간: %d\n", 
	    		   pjp.getTarget().getClass().getSimpleName(), 
	               Arrays.toString(pjp.getArgs()), (end-start));
	    }
	    return result;
	 }
}
