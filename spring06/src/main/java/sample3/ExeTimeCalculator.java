package sample3;

public class ExeTimeCalculator implements Calculator{

	
	private Calculator delegate;	// 대리
	
	public ExeTimeCalculator(Calculator delegate) {	// 의존 주입(DI)
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long exec = delegate.factorial(num);	// 핵심 기 능
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 수행 시간 : %d\n",
				delegate.getClass().getSimpleName(),
				num, (end-start));
		delegate.factorial(num);
		return exec;
	}

	
}
