package com.chinasoft.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasoft.pojo.User;

public interface UserMapper {
	
	public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);

	public User selectUserById(@Param("id") Integer id);
	
	public int modify(User user);
}
