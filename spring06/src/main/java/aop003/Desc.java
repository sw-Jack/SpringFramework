package aop003;

public class Desc {
	
}

/*
	- AOP는 횡단 관심사를 한 곳에서 정의하고 이 후 필요한 부분에 코드를 주입해주는 방법
	- 횡단 관심사 코드를 어느 시점에 주입할 수 있는가?
	- 객체 지향에서 코드(로직)가 있는 곳은 메서드 내부에 존재
	- 메서드가 호출될 때 횡단 관심코드를 주입해 줄 수 있는 시점들이 존재

	Before: 메서드 시작 전 시점
	After: 메서드 종료 후 시점
		AfterReturning: 메서드가 정상적 종료 시점
		AfterThrowing: 메서드에서 예외가 발생되어 종료된 시점
		
	Around: 위 시점 전체를 포함하여 개발자가 원하는 시점을 선택할 수 있는 시점 *

	AOP핵심 개념
		- 스프링 AOP는 인터페이스 기반!
		- 스프링 AOP는 프록시를 기반으로 한다.
		- 스프링 AOP는 런타임(실행 중)기반이다.
		
	AOP 관련 용어
		- Aspect : 관점, 측면, 양상
		- Advisor : 조언자, 고문
		- Advice : 조언, 충고
		- Pointcut : 자르는 지점
		- JoinPoint : 결합점
		
	※JoinPoint개념

	Pointcut지시자
	형식:
	[접근제한자] 반환자료형패턴[패키지&클래스패턴.]메서드이름패턴([파라미터패턴])[throws예외패턴]
	
	ex)
	* runSomething()
	- 접근제한자는 무엇이든
	- 반환 자료형은 무엇이든
	- 모든 패키지에서(생략)
	- 모든 클래스내에(생략)
	- 메서드 이름은 runSomething이고
	- 파라미터는 없고
	- 예외는 있든 없든
	위 조건에 맞는 JoinPoint가 Pointcut이 된다.
	
	public void aop002.Boy.runSomething()
	- 접근 제한자가 public이고
	- 반환 자료형이 void이고
	- aop002패키지에
	- Boy라는 클래스에
	- runSomething이라는 메서드가
	- 파라미터가 없고
	- 예외는 있든 없든
	위 조건에 맞는 부분이 Pointcut이다.
	
	※Advice(언제, 무엇을)
	pointcut지점에 언제, 무엇을 적용할 것인지를 정의한 로직(메서드)을 의미
	ex) Pointcut이 시작(호출)되기 전(@Before)에 before()메서드를 실행
	
	※Aspect(관점)
	AOP에서 여러 개의 Advice와 여러 개의 Pointcut의 결합된 것을 의미
	Aspect = Advice + Pointcut
	
	언제, 어디에, 무엇을 적용할 것이냐!
	예제에서 @Aspect가 선언된 클래스의 내용이다.
	pointcut이 시작되기 전(@Before)에 before()메서드를 실행하는 것 
	
	설정(적용) 방법 두 가지
	- @Aspect를 이용하는 어노테이션을 활용하는 방법
	- POJO(Plain Old Java Object)/XML을 활용하는 방법
	POJO: 어떤 것도 의존하지 않는 순수한 자바 객체
*/