package com.apipothi.namingserver;
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
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//http://localhost:8761/

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServerApplication {
	private final static Logger logger = LoggerFactory.getLogger(EurekaNamingServerApplication.class);

	public static void main(String[] args) {
		logger.info("***eureka-naming-server-App-STARTING***");
		SpringApplication.run(EurekaNamingServerApplication.class, args);
		logger.info("***eureka-naming-server-App-COMPLETED***");
	}

}
