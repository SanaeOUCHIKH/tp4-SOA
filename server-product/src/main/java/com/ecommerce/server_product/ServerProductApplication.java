package com.ecommerce.server_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProductApplication.class, args);
	}

}
