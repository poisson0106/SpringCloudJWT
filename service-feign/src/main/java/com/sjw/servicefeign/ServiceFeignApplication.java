package com.sjw.servicefeign;

import com.sjw.servicefeign.utils.JWTUtils;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(basePackages = {"com.sjw.feigninterface"})
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}

	@Bean
	public JWTUtils jwtUtils(){
		return new JWTUtils();
	}
}
