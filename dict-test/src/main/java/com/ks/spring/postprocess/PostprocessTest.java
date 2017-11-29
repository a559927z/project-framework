package com.ks.spring.postprocess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eg/test-bean.xml")
@ActiveProfiles("test")
public class PostprocessTest implements ApplicationContextAware {

	public ApplicationContext context;

	@Test
	public void beanDefinitionRegistryTest() {

		UserDto s = (UserDto) context.getBean("jackstudent");

		System.out.println(s.getUsername());
		System.out.println(s.getPassword());
		System.out.println(s.getSchool());
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;

	}

}
