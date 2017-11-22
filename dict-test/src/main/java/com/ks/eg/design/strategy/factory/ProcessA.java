package com.ks.eg.design.strategy.factory;

/**
 * A策略处理
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessA implements Process {

	@Override
	public void process() {
		System.out.println("A策略处理");
	}

}
