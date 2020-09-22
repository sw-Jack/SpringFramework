package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client2;
import spring.Client3;

@Configuration
public class JavaConfig {
	
	@Bean
	public Client2 client2() {	// 모듈 사용
		Client2 client = new Client2();
		client.setHost("서버");
		return client;			
	}
	
	@Bean(initMethod="connect", destroyMethod="closeConnection")
	public Client3 client3() {	// 직접 메서드 작성
		Client3 client = new Client3();
		client.setHost("서버");
		return client;
	}
}
