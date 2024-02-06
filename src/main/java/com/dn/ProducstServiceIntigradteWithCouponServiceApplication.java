package com.dn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProducstServiceIntigradteWithCouponServiceApplication {
	
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducstServiceIntigradteWithCouponServiceApplication.class, args);
	}

}
