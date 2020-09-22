package spring;

public class Client3 {
	private String host;
	
	public Client3() {
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
	
	// 소멸 메서드
	public void closeConnection( ) {
		System.out.println("Client3.closeConnection() 실행");
	}
}
