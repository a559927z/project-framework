package com.ks.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eg/test-mybatis.xml")
@ActiveProfiles("test")
public class TestMybatis {

	@Autowired
	private MbService mbService;

	@Test
	public void findTbTest() {
		Integer tb = mbService.findTb();
		System.out.println(tb);
	}

	@Test
	public void queryTbProviderTest() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("age", 15);
		List<UserDto> rs = mbService.queryTb(paramMap);
		for (UserDto dto : rs) {
			System.out.println(dto.getUsername() + "__" + dto.getAge());
		}
	}

}
