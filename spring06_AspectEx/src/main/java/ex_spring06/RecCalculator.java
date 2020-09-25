package ex_spring06;

public class RecCalculator implements Calculator{

	@Override
	public long fact(long num) {
		if(num<=1) return 1;
		else return (num * fact(num-1));
	}
	
}
