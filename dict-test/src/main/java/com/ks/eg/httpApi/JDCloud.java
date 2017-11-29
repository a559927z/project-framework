package com.ks.eg.httpApi;

import java.util.List;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface JDCloud {

	// https://way.jd.com/jisuapi/get?channel=头条&num=10&start=0&appkey=您申请的APPKEY
	// RequestLine注解声明请求方法和请求地址,可以允许有查询参数
	@RequestLine("GET https://way.jd.com/jisuapi/get?channel=头条&num=10&start=0&appkey={appkey}")
	List<NewsDto> getNews(@Param("appkey") String appkey);
}


