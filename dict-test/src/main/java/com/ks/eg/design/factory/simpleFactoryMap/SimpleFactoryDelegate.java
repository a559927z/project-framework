package com.ks.eg.design.factory.simpleFactoryMap;

import java.net.URL;

import com.ks.eg.design.factory.factoryMethod.FactoryMethodTest;

import net.chinahrd.utils.PropertiesUtil;
import net.chinahrd.utils.XMLUtil;

/**
 * Title: SimpleFactoryDelegate <br/>
 * Description: 委托者
 * 
 * @author jxzhang
 * @DATE 2017年11月29日 上午11:02:05
 * @Verdion 1.0 版本
 */
public class SimpleFactoryDelegate {

	/**
	 * 委托xml
	 * 
	 * @return
	 */
	public String xmlDelegate() {
		URL resourceURI = FactoryMethodTest.class.getResource("/com/ks/eg/design/factory/FactoryConfig.xml");
		String fileFullPath = resourceURI.getFile();
		return XMLUtil.getValueByTagName(fileFullPath, "chartType");
	}

	public String propersDelegate() {
		String fileFullPath = "com/ks/eg/design/factory/FactoryConfig.properties";
		return PropertiesUtil.getProperty(fileFullPath, "chartType");
	}

}