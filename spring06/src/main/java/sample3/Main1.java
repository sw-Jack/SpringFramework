package sample3;

public class Main1 {

	public static void main(String[] args) {
		
		ExeTimeCalculator calc1 = new ExeTimeCalculator(new ImplCalculator());
		ExeTimeCalculator calc2 = new ExeTimeCalculator(new RecCalculator());

		long n1 = calc1.factorial(30);
		long n2 = calc2.factorial(30);
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);

	}

}
