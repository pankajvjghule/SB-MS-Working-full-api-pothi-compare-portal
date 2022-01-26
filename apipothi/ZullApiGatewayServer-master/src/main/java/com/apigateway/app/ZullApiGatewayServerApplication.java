package com.apigateway.app;
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
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZullApiGatewayServerApplication {

	private final static Logger logger = LoggerFactory.getLogger(ZullApiGatewayServerApplication.class);
	public static void main(String[] args) {
		logger.info("***zull-apigateway-service-App-STARTING***");
		SpringApplication.run(ZullApiGatewayServerApplication.class, args);
		logger.info("***zull-apigateway-service-App-COMPLETED***");
	}

	//to gget unique identificn number for req going thru api gateway(present in all m.s.)
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	 

}
