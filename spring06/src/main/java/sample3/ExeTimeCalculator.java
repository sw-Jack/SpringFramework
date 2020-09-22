package sample3;

public class ExeTimeCalculator implements Calculator{

	
	private Calculator delegate;	// 대리
	
	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 수행 시간 : %d\n",
				delegate.getClass().getSimpleName(),
				num, (end-start));
		delegate.factorial(num);
		return result;
	}

	
}
