package quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	// Spring 이 없는 경우
	/*
		Calculator cal = new Calculator();
	*/
	    GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCTX.xml");
		Calculator cal = ctx.getBean("calc", Calculator.class);
		
		Scanner in = new Scanner(System.in);
		System.out.print("연산자 입력 : ");		
		char op = in.nextLine().charAt(0);
		System.out.print("첫 번째 수 입력 : ");
		int n1 = in.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int n2 = in.nextInt();
		int ret = 0;
		switch(op) {
		case '+' : ret = cal.add(n1, n2); break;
		case '-' : ret = cal.min(n1, n2); break;
		case '*' : ret = cal.mul(n1, n2); break;
		case '/' : ret = cal.div(n1, n2); break;
		}
		System.out.println("연산결과 " + "\n" + n1 + op + n2 + "=" + ret);
	}

}
