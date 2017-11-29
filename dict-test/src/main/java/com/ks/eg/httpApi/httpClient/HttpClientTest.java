package com.ks.eg.httpApi.httpClient;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import net.chinahrd.utils.HttpClientUtil;


public class HttpClientTest {

	private static String host = "http://localhost:8080/dict-Test";

	@Test
	public void postTest() {
		String url = host + "/test/postTest";

		UserDto dto = new UserDto();
		dto.setUsername("xxx");
		dto.setPassword("jjj");

		String json = JSON.toJSONString(dto);
		String postBody = HttpClientUtil.postBody(json, url);

		System.out.println(postBody);
	}
}
