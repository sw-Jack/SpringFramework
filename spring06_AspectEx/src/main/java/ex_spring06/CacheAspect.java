package ex_spring06;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)	// CacheAspect는 1번
public class CacheAspect {

	private Map<Long, Object> cache = new HashMap<>();
	
	@Around("execution(public * fact(long))")
	public Object execute(ProceedingJoinPoint pjp) throws Throwable {
		Long num = (Long)pjp.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect : Cache 에서 구함[%d]\n", num);
			return cache.get(num);
		}
		Object result = pjp.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect : Cache에 추가 [%d]\n", num);
		return result;
	}
	
}
