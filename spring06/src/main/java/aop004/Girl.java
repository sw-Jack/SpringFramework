package aop004;

public class Girl implements Person{
	
	@Override
	public void runSomething() {
		
		System.out.println("요리를 한다.");		// 핵심 관심(핵심 기능)
	}
}
