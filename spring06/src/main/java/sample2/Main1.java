package sample2;

public class Main1 {

	public static void main(String[] args) {
		
		ImplCalculator calc1 = new ImplCalculator();
		RecCalculator calc2 = new RecCalculator();
		
		// 수행 시간을 체크하고 싶다면?
		// factorial을 호출하는 코드 앞 뒤에 모두 직접 시간을 구하기 위한 코드를 추가해야만 한다.
		// 또는 각 Impl의 factorial 메서드 내의 동일한 내용을 작성해 줄 수도 있다.하지만 재귀 같은 경우 표현이 모호해질 수도 있다.
		long start = 0, end = 0;
		
		start = System.currentTimeMillis();
		long n1 = calc1.factorial(20);
		end = System.currentTimeMillis();
		long exeTime = end - start;
		System.out.println("calc1.factorial 수행 시간 : " + exeTime);
		
		start = System.currentTimeMillis();
		long n2 = calc2.factorial(20);
		end = System.currentTimeMillis();
		exeTime = end - start;
		System.out.println("calc2.factorial 수행 시간 : " + exeTime);
		
		System.out.println(n1 + "\n" + n2);
	}

}
