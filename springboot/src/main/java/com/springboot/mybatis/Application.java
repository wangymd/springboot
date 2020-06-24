package com.springboot.mybatis;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mybatis.pojo.User;
import com.springboot.mybatis.service.UserService;

@RestController
@EnableTransactionManagement//开启事务管理
@MapperScan("com.springboot.mybatis.mapper")
@SpringBootApplication
public class Application {

	@Autowired
	UserService userService;

	@RequestMapping("/test")
	public int test() {
		return userService.test();
	}

	@RequestMapping("/users")
	public int addUsers() {
		return userService.addUsers();
	}
	
	@RequestMapping("/users/{pageNum}/{pageSize}")
	public List<User> queryByPages(@PathVariable("pageNum") int pageNum, @PathVariable(value = "pageSize")  int pageSize) {
		return userService.queryByPages(pageNum, pageSize);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
