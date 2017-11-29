package com.ks.design.factory.simpleFactoryMap;

/**
 * Title: HistogramChart <br/>
 * Description: 具体产品角色
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午8:53:23
 * @Verdion 1.0 版本
 */
public class HistogramChart extends AbstractChartFactory {
	public HistogramChart() {
		System.out.println("创建柱状图！");
	}

	@Override
	public void display() {
		System.out.println("显示柱状图！");
	}

}
