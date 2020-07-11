package com.springboot.conditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(applicationContext.getBeansOfType(EncoderConvert.class));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		applicationContext.close();
	}
}
