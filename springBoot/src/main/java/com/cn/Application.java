package com.cn;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication 
public class Application { 
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws UnknownHostException { 
		SpringApplication app = new SpringApplication(Application.class); 
		Environment environment = app.run(args).getEnvironment(); 
	} 
}

