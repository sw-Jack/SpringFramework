package spring;

public class Client1 {
	private String host;
	
	public Client1() {
		System.out.println("Client() 생성");
	}
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client, setHost() 생성");
	}
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}

}
