package com.springboot.condition;

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
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        applicationContext.getBean(Runnable.class).run();
        
        System.out.println(applicationContext.getBeansOfType(EncoderConvert.class));
        
        applicationContext.close();
    }
}
