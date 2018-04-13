package com.nd.social.css22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nd.social")
@EnableFeignClients("com.nd.social.css22")
@EnableDiscoveryClient
public class Css22Application {

	public static void main(String[] args) {
		SpringApplication.run(Css22Application.class, args);
	}
}
