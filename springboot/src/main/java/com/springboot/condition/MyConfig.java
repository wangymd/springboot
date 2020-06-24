package com.springboot.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.springboot.condition.EncoderConvert;
import com.springboot.condition.GBKEncoderConvert;
import com.springboot.condition.GBKEncoderConvertCondition;
import com.springboot.condition.UTF8EncoderConvert;
import com.springboot.condition.UTF8EncoderConvertCondition;

@Component
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
