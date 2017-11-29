package com.ks.eg.design.factory.simpleFactory;

public class SimpleFactoryTest {

	public static void main(String args[]) {

//		String chartType = new SimpleFactoryDelegate().xmlDelegate();
		String chartType = new SimpleFactoryDelegate().propersDelegate();

		AbstractChartFactory chart = AbstractChartFactory.getChart(chartType); // 通过静态工厂方法创建产品
		chart.display();

	}
}
