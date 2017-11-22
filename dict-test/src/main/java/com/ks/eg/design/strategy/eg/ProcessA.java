package com.ks.eg.design.strategy.eg;

/**
 * A策略处理
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessA implements Process {

	@Override
	public double calcPrice(double booksPrice) {

		System.out.println("对于初级会员的没有折扣");
		return booksPrice;
	}

}
