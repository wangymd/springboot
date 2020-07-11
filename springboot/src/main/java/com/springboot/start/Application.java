package com.springboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动过程分析
 * @author win7
 *
 */
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		//AnnotationConfigServletWebServerApplicationContext
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("beanDefinitionName = " + beanDefinitionName);
		}
		
		
		applicationContext.close();
	}
}