package com.ks.design.factory.simpleFactoryMap;

/**
 * Title: LineChart <br/>
 * Description: 具体产品角色
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午8:53:45
 * @Verdion 1.0 版本
 */
public class LineChart extends AbstractChartFactory {

	public LineChart() {
		System.out.println("创建折线图！");
	}

	@Override
	public void display() {
		System.out.println("显示折线图！");
	}

}
