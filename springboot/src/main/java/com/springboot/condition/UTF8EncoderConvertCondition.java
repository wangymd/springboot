package com.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UTF8EncoderConvertCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encode = context.getEnvironment().getProperty("file.encode");
		if("utf-8".equalsIgnoreCase(encode)) return true;
		return false;
	}

}
