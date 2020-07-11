package com.springboot.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	@Conditional(GBKEncoderConvertCondition.class)
	public EncoderConvert GBKEncoderConvert() {
		return new GBKEncoderConvert();
	}
	
	@Bean
	@Conditional(UTF8EncoderConvertCondition.class)
	public EncoderConvert UTF8EncoderConvert() {
		return new UTF8EncoderConvert();
	}
}
