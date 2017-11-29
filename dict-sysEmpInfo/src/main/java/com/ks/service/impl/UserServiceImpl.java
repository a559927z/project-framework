package com.ks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ks.dao.UserDao;
import com.ks.dto.UserDto;
import com.ks.service.UserService;

/**
 * 用户Service实现类
 * Created by wqcai on 15/6/8.
 */

/**
 * @author 家安
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDto findUserById(String customerId, String userId) {
		System.out.println("==========" + userId);
		if (StringUtils.isEmpty(userId)) {
			return null;
		}
		UserDto dto = userDao.findUserById(customerId, userId);
		return dto;
	}

	@Override
	public String testSql() {
		return userDao.testSql();
	}

}
