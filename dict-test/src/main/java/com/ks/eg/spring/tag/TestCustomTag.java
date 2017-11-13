package com.ks.eg.spring.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomTag {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:eg/test-tag.xml");
		System.out.println(cxt);

		UserEntity bean = (UserEntity) cxt.getBean("userBean");
		System.out.println(bean.getName());
		System.out.println(bean.getEmail());

	}
}
