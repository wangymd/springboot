package com.springboot.exception;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * 参数验证
 * @author win7
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("/test")
@Validated
public class Application
{	
	
	/**
	 * @Valid需要@Validated配合使用，否则不生效
	 * @param msg
	 * @return
	 */
	@RequestMapping("/testValidParams")
	public String testValidParams(@Valid @Size(min=1,max=10,message="msg长度大于1小于10") @RequestParam(value="msg",required=true) String msg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", msg);
		return jsonObject.toJSONString();
	}
	
	@RequestMapping("/testValidPo")
	public ResponseEntity<User> testValidPo(@Valid @RequestBody User user) {
		return ResponseEntity.ok().body(user);
	}
	
	@Bean
	public Runnable createRunnable() {
		return () -> {System.out.println( "springboot is running ok" );};
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
