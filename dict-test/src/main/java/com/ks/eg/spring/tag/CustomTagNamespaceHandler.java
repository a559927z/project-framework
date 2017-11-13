package com.ks.eg.spring.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CustomTagNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		this.registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}

}
