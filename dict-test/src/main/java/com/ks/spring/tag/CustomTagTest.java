package com.ks.spring.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ks.dto.BaseDto;

public class CustomTagTest {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:eg/test-tag.xml");
		System.out.println(cxt);

		BaseDto bean = (BaseDto) cxt.getBean("userBean");
		System.out.println(bean.getK());
		System.out.println(bean.getV());

	}
}
