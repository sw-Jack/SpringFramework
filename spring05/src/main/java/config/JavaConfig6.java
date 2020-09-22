package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;
import spring.Client3;
import spring.Client5;

@Configuration
public class JavaConfig6 {
	
	@Bean
	@Scope("prototype")	// getBean 할때마다 객체 생성
	public Client5 client5() {	// 모듈 사용
		Client5 client = new Client5();
		client.setHost("서버");
		return client;			
	}

}
