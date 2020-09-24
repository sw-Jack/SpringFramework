package aop005;

public class Boy implements Person{
	
	@Override
	public void runSomething() {
		
		System.out.println("(기준/공통 기능) 컴퓨터로 게임을 한다.");	// 핵심 관심(핵심 기능)
	}

}
