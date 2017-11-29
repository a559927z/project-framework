package com.ks.spring.interceptor;

import org.junit.Test;

import net.chinahrd.utils.HttpClientUtil;

public class InterceptorTest {

	private static String host = "http://localhost:8080/dict-Test";

	@Test
	public void postTest() {
		String url = host + "/test/stringInterceptorRegister";

		String postBody = HttpClientUtil.get(url);

		System.out.println(postBody);
	}
}
