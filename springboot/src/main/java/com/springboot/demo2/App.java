package com.springboot.demo2;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
        SpringApplication springApplication = new SpringApplication();
        Set<String> sources = new HashSet<>();
        sources.add("com.springboot.demo2.App");
        springApplication.setSources(sources);
        ConfigurableApplicationContext applicationContext = springApplication.run(args);
        applicationContext.getBean(Runnable.class).run();
        
        applicationContext.close();
    }
}
