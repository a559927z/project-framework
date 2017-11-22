package com.ks.eg.design.strategy.eg;

/**
 * C策略处理
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessC implements Process {

	@Override
	public double calcPrice(double booksPrice) {

		System.out.println("对于高级会员的折扣为20%");
		return booksPrice * 0.8;
	}

}
