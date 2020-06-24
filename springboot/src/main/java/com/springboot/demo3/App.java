package com.springboot.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * spring.config.name	指定配置文件名
 * spring.config.location	指定配置文件位置
 * @author win7
 *
 */
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
        
        System.out.println(applicationContext.getEnvironment().getProperty("spring.application.name"));
        
        applicationContext.getBean(MyConfig.class).show();
        
        
        applicationContext.close();
    }
}
