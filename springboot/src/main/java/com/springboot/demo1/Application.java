package com.springboot.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Application
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StartUpConfig.class, args);
        applicationContext.getBean(Runnable.class).run();
        
//        applicationContext.close();
    }
}
