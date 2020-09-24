package aop010;

public class Boy implements Person{
	
	@Override
	public void runSomething() {
		
		System.out.println("컴퓨터로 게임을 한다.");	// 핵심 관심(핵심 기능)
		throw new FireException("불남"); // 임의로 예외 발생
	}

}
