package com.springboot.mybatis.service;

import java.util.List;

import com.springboot.mybatis.pojo.User;

public interface UserService {
	
	int test();

	int addUsers();

	List<User> queryByPages(int pageNum, int pageSize);

}
