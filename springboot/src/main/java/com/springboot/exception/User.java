package com.springboot.exception;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

	@NotNull(message="id不能为空")
	Integer id;
	
	@Size(min=1,max=8,message="name长度在1和8之间")
	@NotNull(message="name不能为空")
	String name;
	
	@Min(value=1,message="age年龄必须大于等于1")
	@Max(value=100,message="age年龄必须小于100")
	@NotNull(message="age不能为空")
	Integer age;
}
