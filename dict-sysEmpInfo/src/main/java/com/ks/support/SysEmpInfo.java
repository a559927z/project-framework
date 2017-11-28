package com.ks.support;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysEmpInfo {
	private final static Logger logger = LoggerFactory.getLogger(SysEmpInfo.class);

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
		context.start();

		logger.info("服务已经启动...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
