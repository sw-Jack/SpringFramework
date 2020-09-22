package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2 implements InitializingBean, DisposableBean {
	private String host;
	
	public Client2() {
		System.out.println("Client2() 생성");
	}
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2, setHost() 생성");
	}
	
	public void send() {
		System.out.println("Client2.send() to " + host);
	}
	
	// 소멸자 역할 : ctx.close() 호출 시 실행
	@Override
	public void destroy() throws Exception {
		System.out.println("Client2.destroy() 실행");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client2.afterPropertiesSet() 실행");
	}
}
