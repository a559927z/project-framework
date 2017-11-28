package com.ks.eg.design.factory.factoryMethod;

import java.net.URL;

import net.chinahrd.utils.XMLUtil;

public class FactoryMethodTest {

	public static void main(String[] args) {

		URL resourceURI = FactoryMethodTest.class.getResource("/com/ks/eg/design/factory/FactoryConfig.xml");

		String fileFullPath = resourceURI.getFile();

		AbstractLoggerFactory factory;
		factory = (AbstractLoggerFactory) XMLUtil.getBeanByTagName(fileFullPath, "className");
		factory.writeLog(); // 直接使用工厂对象来调用产品对象的业务方法
	}
}
