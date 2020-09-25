package ex_spring06;

public class ImplCalculator implements Calculator{

	@Override
	public long fact(long num) {
		long result = 1;
		for(int i=1; i<=num; i++) {
			result *= i;
		}
		return result;
	}
	
}
