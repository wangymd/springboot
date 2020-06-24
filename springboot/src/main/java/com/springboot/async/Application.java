package com.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync//开启异步
public class Application
{
	@Bean
	public Runnable createRunnable() {
		return () -> {System.out.println( "springboot is running ok" );};
	}
	
    public static void main( String[] args )
    {
       SpringApplication.run(Application.class, args);
    }
}
