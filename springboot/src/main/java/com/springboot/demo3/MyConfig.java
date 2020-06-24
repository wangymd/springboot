package com.springboot.demo3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@Value("${default.value:100}")
	String defaultValue;
	
	public void show() {
		System.out.println("applicationName:" + applicationName);
		System.out.println("defaultValue:" + defaultValue);
	}

}
