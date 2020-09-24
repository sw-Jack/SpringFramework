package aop006;

public class Girl implements Person{
	
	@Override
	public void runSomething() {
		
		System.out.println("(기준/공통 기능) 요리를 한다.");		// 핵심 관심(핵심 기능)
	}
}
