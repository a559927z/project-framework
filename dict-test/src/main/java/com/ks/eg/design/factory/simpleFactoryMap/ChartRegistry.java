package com.ks.eg.design.factory.simpleFactoryMap;

import java.util.HashMap;
import java.util.Map;

public class ChartRegistry {

	private static Map<String, AbstractChartFactory> factoryMap = new HashMap<>();

	static {
		factoryMap.put("histogram", new HistogramChart());
		factoryMap.put("pie", new PieChart());
		factoryMap.put("line", new LineChart());
		System.out.println("注册柱状图！");
		System.out.println("注册饼状图！");
		System.out.println("注册折线图！");
	}

	public static Map<String, AbstractChartFactory> getFactoryMap() {
		return factoryMap;
	}

}
