package com.ks.eg.design.factory.simpleFactory;

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
		AbstractChartFactory chart = null;
		if (type.equalsIgnoreCase("histogram")) {
			chart = new HistogramChart();
			System.out.println("初始化设置柱状图！");
		} else if (type.equalsIgnoreCase("pie")) {
			chart = new PieChart();
			System.out.println("初始化设置饼状图！");
		} else if (type.equalsIgnoreCase("line")) {
			chart = new LineChart();
			System.out.println("初始化设置折线图！");
		}
		return chart;
	}
}
