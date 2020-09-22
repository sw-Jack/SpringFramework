package spring;

public class Client5 {
	private String host;
	
	public Client5() {
		System.out.println("Client3() 생성");
	}
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client3, setHost() 생성");
	}
	
	public void send() {
		System.out.println("Client3.send() to " + host);
	}
	
	// 초기화 메서드
	public void connect() {
		System.out.println("Client3.connect() 실행");
	}
	
	// 소멸 메서드 (destroy-method가 지정되지 않으면 close, shutdown 이름의 메서드 디폴트 호출
	public void shutdown() {
		System.out.println("Client3.shutdown() 실행");
	}
}
