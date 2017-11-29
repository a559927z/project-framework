package com.ks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-empinfo.xml")
// @ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void findTbTest() {
		UserDto findUserById = userService.findUserById("b5c9410dc7e4422c8e0189c7f8056b5f", "jxzhang");
		System.out.println(findUserById);
		// String testSql = userService.testSql();
		// System.out.println(testSql);
	}

}
