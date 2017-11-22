package com.ks.eg.design.strategy.base;

/**
 * 策略上下文
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessContext {

	/**
	 * 策略抽象类引用
	 */
	private Process process;

	// 初始化让客户提供使用什么策略
	public ProcessContext(Process process) {
		this.process = process;
	}

	// 可以对客户端的功能入口。
	public void process() {
		// 这个功能入口调用策略抽象里的所有策略抽象入口
		process.process();
	};

}
