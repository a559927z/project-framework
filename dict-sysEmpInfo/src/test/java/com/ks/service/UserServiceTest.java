package com.ks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-empInfo.xml")
//@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void findTbTest() {
//		UserDto findUserById = userService.findUserById("b5c9410dc7e4422c8e0189c7f8056b5f", "USER_superAdmin");
//		System.out.pri ntln(findUserById);
		 String testSql = userService.testSql();
		System.out.println(testSql);
	}

}
