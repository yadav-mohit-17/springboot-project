package com.app.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudConfigServerApplication.class, args);
	}

}
