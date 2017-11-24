package com.ks;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

	String testSql();

}
