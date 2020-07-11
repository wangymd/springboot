package com.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.springboot.mybatis.pojo.User;

@Mapper
public interface UserMapper {
	
	//测试用
	@Select(" select count(id) from user ")
	int test();
	
	int batchInsert(@Param("users") List<User> Users);
	
	//内存分页
	@Select(" select * from user ")
	List<User> queryUsersByPage1(RowBounds rowBounds);
	
	//物理分页
	@Select(" select * from user limit #{offset,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}")
	List<User> queryUsersByPage2(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Select(" select * from user ")
	List<User> queryUsers(@Param("id")Integer id, String name);

}
