package com.springboot.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 定义Condition实现类
 * @author wangymd
 *
 */
public class GBKEncoderConvertCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encode = context.getEnvironment().getProperty("file.encode");
		if("gbk".equalsIgnoreCase(encode)) return true;
		return false;
	}

}
