package com.ks.eg.design.factory.simpleFactory;

import java.net.URL;
import java.util.Arrays;

import com.ks.eg.design.factory.factoryMethod.FactoryMethodTest;

import net.chinahrd.utils.XMLUtil;

public class SimpleFactoryTest {

	public static void main(String args[]) {
		URL resourceURI = FactoryMethodTest.class.getResource("/com/ks/eg/design/factory/FactoryConfig.xml");
		String fileFullPath = resourceURI.getFile();

		String chartType = XMLUtil.getValueByTagName(fileFullPath, "chartType");

		AbstractChartFactory chart = AbstractChartFactory.getChart(chartType); // 通过静态工厂方法创建产品
		chart.display();
		
	}
}
