package com.ks.eg.design.strategy.factory;

/**
 * 策略模式 + 工厂模式 （这样客户就不用记有那些策略类。只记得有这个策略上下文类就可以了）
 * 
 * @author jxzhang on 2017年8月12日
 * @Verdion 1.0 版本
 */
public class ProcessTest {

	public static void main(String[] args) {
		// ProcessContext pc = new ProcessContext(1);
		// ProcessContext pc = new ProcessContext(2);
		ProcessContext pc = new ProcessContext(3);
		pc.process();
	}
}
