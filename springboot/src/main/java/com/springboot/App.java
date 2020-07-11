package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动过程分析
 * @author win7
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(App.class);
		springApplication.run(args);
	}
}
