package com.ks.eg.spring.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class My1 implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryPostProcessor my1");

		BeanDefinition bd = arg0.getBeanDefinition("jackstudent");

		MutablePropertyValues mpv = bd.getPropertyValues();

		mpv.addPropertyValue("password", "123456-vip");
	}

}
