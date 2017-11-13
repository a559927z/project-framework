package com.ks.eg.design.strategy;

/**
 * 策略模式(优点：横向扩展需求)
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessTest {

	/**
	 * 没在使用策略模式，当我们的业务如果有多种策略（算法里）只能在这里加case形成纵向开展代码
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		switch (i) {
		case 1:
			System.out.println("A策略处理");
			break;
		case 2:
			System.out.println("B策略处理");
			break;
		case 3:
			System.out.println("C策略处理");
			break;
		}
	}
}
