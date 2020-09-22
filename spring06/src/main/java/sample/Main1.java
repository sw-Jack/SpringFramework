package sample;

public class Main1 {

	public static void main(String[] args) {
		
		ImplCalculator calc1 = new ImplCalculator();
		RecCalculator calc2 = new RecCalculator();
		
		long n1 = calc1.factorial(4);
		long n2 = calc2.factorial(4);
		
		System.out.println(n1 + "\n" + n2);
	}

}
