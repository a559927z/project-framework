package com.ks.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {

	private Logger logger = LoggerFactory.getLogger(LogDemo.class);

	private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LogDemo.class);

	public void test1() {
		int i = 123;
		int j = 456;
		logger.error("{}_AAAA_{}", i, j);
	}

	public void test2() {
		int i = 123;
		log.error("xxx{}", new Throwable());
	}

	public static void main(String[] args) {
		new LogDemo().test1();
		new LogDemo().test2();
	}

}
