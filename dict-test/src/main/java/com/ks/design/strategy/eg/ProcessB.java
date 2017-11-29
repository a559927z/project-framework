package com.ks.design.strategy.eg;

/**
 * B策略处理
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessB implements Process {

	@Override
	public double calcPrice(double booksPrice) {

		System.out.println("对于中级会员的折扣为10%");
		return booksPrice * 0.9;
	}
}
