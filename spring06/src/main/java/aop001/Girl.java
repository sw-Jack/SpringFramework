package aop001;

public class Girl {
	
	public void runSomething() {
		System.out.println("열쇠로 문을 열고 집에 들어간다.");			// 횡단(공통) 관심
		
		try {
			System.out.println("요리를 한다.");		// 핵심 관심(핵심 기능)
		} catch(Exception e) {
			if(e.getMessage().contentEquals("집에 불남")) {		// 횡단(공통) 관심
				System.out.println("119에 신고한다.");		// 횡단(공통) 관심
			}
		} finally {
			System.out.println("소등하고 잔다.");		// 횡단(공통) 관심
		}
		System.out.println("문을 잠그고 집을 나온다.");		// 횡단(공통) 관심
	}
}
