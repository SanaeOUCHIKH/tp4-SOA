package com.ecommerce.server_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ServerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOrderApplication.class, args);
	}

}
