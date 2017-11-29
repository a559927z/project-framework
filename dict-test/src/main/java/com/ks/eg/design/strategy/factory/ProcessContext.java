package com.ks.eg.design.strategy.factory;

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
	private Process pc;

	public ProcessContext(int i) {
		// 简单工厂模式
		switch (i) {
		case 1:
			pc = new ProcessA();
			break;
		case 2:
			pc = new ProcessB();
			break;
		case 3:
			pc = new ProcessC();
			break;
		}
	}

	// 可以对客户端的功能入口。
	public void process() {
		// 这个功能入口调用策略抽象里的所有策略抽象入口
		this.pc.process();
	};

}
