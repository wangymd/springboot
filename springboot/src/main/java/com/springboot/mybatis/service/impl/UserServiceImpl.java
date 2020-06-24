package com.springboot.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.springboot.mybatis.mapper.UserMapper;
import com.springboot.mybatis.pojo.User;
import com.springboot.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public int test() {
		return userMapper.test();
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=-1)
	@Override
	public int addUsers() {
		ArrayList<User> list = Lists.newArrayList();
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setName("u" + i);
			list.add(user);
		}
		return userMapper.batchInsert(list);
	}

	@Override
	public List<User> queryByPages(int pageNum, int pageSize) {
		int offset = pageNum == 0 ? pageNum : pageNum * (pageSize = pageSize <= 0 ? 10 : pageSize);
//		RowBounds rowBounds = new RowBounds(offset, pageSize);
//		return userMapper.queryUsersByPage1(rowBounds);
		return userMapper.queryUsersByPage2(offset,pageSize);
	}

}
