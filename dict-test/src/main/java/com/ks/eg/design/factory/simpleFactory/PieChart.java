package com.ks.eg.design.factory.simpleFactory;

/**
 * Title: PieChart <br/>
 * Description: 具体产品角色
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午8:53:56
 * @Verdion 1.0 版本
 */
public class PieChart extends AbstractChartFactory {
	public PieChart() {
		System.out.println("创建饼状图！");
	}

	@Override
	public void display() {
		System.out.println("显示饼状图！");
	}

}
