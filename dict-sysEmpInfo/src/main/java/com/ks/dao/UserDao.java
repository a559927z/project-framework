package com.ks.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ks.dto.UserDto;

@Repository("userDao")
public interface UserDao {

	UserDto findUserById(@Param("customerId") String customerId, @Param("userId") String userId);

	String testSql();

}
