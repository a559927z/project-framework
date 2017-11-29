package com.ks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ks.dto.BaseDto;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/stringInterceptorRegister", method = RequestMethod.GET)
	public String stringInterceptorRegister(HttpServletRequest request) {
		System.out.println("stringInterceptorRegister");
		return "springIntercept";
	}

	@ResponseBody
	@RequestMapping(value = "/postTest", method = RequestMethod.POST)
	public String postTest(@RequestBody BaseDto dto) {
		System.out.println(dto.getK());
		System.out.println(dto.getV());
		return "success";
	}

}
