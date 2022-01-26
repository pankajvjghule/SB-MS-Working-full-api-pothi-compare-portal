package com.apipothi.warehouse;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//http://localhost:8080/swagger-ui.html
@SpringBootApplication
@EnableDiscoveryClient
public class WarehouseApplication {
	private final static Logger logger = LoggerFactory.getLogger(WarehouseApplication.class);
	public static void main(String[] args) {
		logger.info("******-WarehouseApplication-START");
		SpringApplication.run(WarehouseApplication.class, args);
		logger.info("******-WarehouseApplication-END");
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
