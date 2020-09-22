package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client2;
import spring.Client3;
import spring.Client5;

@Configuration
public class JavaConfig5 {
	
	@Bean
	public Client5 client5() {	// 모듈 사용
		Client5 client = new Client5();
		client.setHost("서버");
		return client;			
	}

}
