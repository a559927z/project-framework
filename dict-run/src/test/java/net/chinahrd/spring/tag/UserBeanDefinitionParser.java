package net.chinahrd.spring.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserEntity.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String email = element.getAttribute("email");

		if (StringUtils.hasText(name)) {
			// 构造器贬值
			builder.addConstructorArgValue(name);
			builder.addConstructorArgValue(email);
		}
		if (StringUtils.hasText(email)) {
			// getset贬值
			builder.addPropertyValue("email", email);
		}

	}

}
