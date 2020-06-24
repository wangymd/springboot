package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App
{
	@Bean
	public Runnable createRunnable() {
		return () -> {System.out.println( "springboot is running ok" );};
	}
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
