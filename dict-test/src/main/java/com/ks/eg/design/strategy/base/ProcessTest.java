package com.ks.eg.design.strategy.base;

/**
 * 策略模式(优点：横向扩展需求)
 * 
 * 1：定多种策略，这个样就是横向添加不影响逻辑代码 。<br/>
 * 2：所有策略抽象一个方法入口。<br/>
 * 3：定义一个这功能的上下文。这上下文初始化时要有策略抽象类的引用。并可以对客户端的功能入口。<br/>
 * 4：这个功能入口调用策略抽象里的所有策略抽象入口。
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessTest {

	public static void main(String[] args) {
		ProcessContext pc = null;
		int i = 1;
		switch (i) {
		case 1:
			pc = new ProcessContext(new ProcessA());
			break;
		case 2:
			pc = new ProcessContext(new ProcessB());
			break;
		case 3:
			pc = new ProcessContext(new ProcessC());
			break;
		}
		pc.process();
	}
}
