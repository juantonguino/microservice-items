package com.codeandapps.microservice.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name ="microservice-products")
@EnableEurekaClient
public class MicroserviceItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceItemsApplication.class, args);
	}

}
