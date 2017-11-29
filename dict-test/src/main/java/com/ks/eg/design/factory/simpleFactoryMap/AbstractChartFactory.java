package com.ks.eg.design.factory.simpleFactoryMap;

/**
 * Title: ChartFactory <br/>
 * Description: 工厂角色+抽象产品角色
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午8:52:34
 * @Verdion 1.0 版本
 */
public abstract class AbstractChartFactory {

	// 抽象产品角色
	public abstract void display();

	// 静态工厂方法(工厂角色)
	public static AbstractChartFactory getChart(String type) {

		AbstractChartFactory chart = ChartRegistry.getFactoryMap().get(type);
		return chart;
	}
}
