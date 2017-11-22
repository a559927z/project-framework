package com.ks.eg.design.strategy.eg;

/**
 * 策略处理器
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public interface Process {

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double calcPrice(double booksPrice);
}
