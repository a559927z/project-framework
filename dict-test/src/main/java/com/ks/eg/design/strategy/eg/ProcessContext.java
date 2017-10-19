package com.ks.eg.design.strategy.eg;

/**
 * 策略上下文
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessContext {

	// 持有一个具体的策略对象
	private Process process;

	/**
	 * 构造函数，传入一个具体的策略对象
	 * 
	 * @param strategy
	 *            具体的策略对象
	 */
	public ProcessContext(Process process) {
		this.process = process;
	}

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double quote(double booksPrice) {
		return this.process.calcPrice(booksPrice);
	};

}
