package sample2;

public class ImplCalculator implements Calculator {
	@Override
	public long factorial(long num) {
		long result = 1;
		for(int i=1; i<=num; i++) {
			result *= i;
		}
		return result;
	}
}
