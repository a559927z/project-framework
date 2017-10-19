package com.ks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/stringInterceptorRegister", method = RequestMethod.GET)
	public String stringInterceptorRegister(HttpServletRequest request) {
		System.out.println("stringInterceptorRegister");
		return "springIntercept";
	}

}
