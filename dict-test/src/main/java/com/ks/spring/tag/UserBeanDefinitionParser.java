package com.ks.spring.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.ks.dto.BaseDto;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return BaseDto.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("k");
		String email = element.getAttribute("v");

		if (StringUtils.hasText(name)) {
			// 构造器贬值
			builder.addConstructorArgValue(name);
			builder.addConstructorArgValue(email);
		}
		if (StringUtils.hasText(email)) {
			// getset贬值
			builder.addPropertyValue("v", email);
		}

	}

}
