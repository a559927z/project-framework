package com.ks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String testSql() {
		return userDao.testSql();
	}

}
