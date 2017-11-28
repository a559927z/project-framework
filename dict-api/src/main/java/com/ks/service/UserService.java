package com.ks.service;

import com.ks.dto.UserDto;

public interface UserService {

	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @return
	 */
	UserDto findUserById(String customerId, String userId);
	
	String testSql();

}
