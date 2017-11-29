package com.ks.design.strategy.eg;

/**
 * 使用场景 假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。比如，
 * 本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。
 * 
 * 根据描述，折扣是根据以下的几个算法中的一个进行的：
 * 
 * 算法一：对初级会员没有折扣。
 * 
 * 算法二：对中级会员提供10%的促销折扣。
 * 
 * 算法三：对高级会员提供20%的促销折扣。
 * 
 * 使用策略模式来实现的结构图如下：
 * 
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class ProcessTest {

	public static void main(String[] args) {
		// 选择并创建需要使用的策略对象
		// Process strategy = new ProcessA();
		// Process strategy = new ProcessB();
		Process strategy = new ProcessC();
		// 创建环境
		ProcessContext price = new ProcessContext(strategy);
		// 计算价格
		double quote = price.quote(300);
		System.out.println("图书的最终价格为：" + quote);
	}

	/**
	 * 从上面的示例可以看出，策略模式仅仅封装算法，提供新的算法插入到已有系统中，以及老算法从系统中“退休”的方法，策略模式并不决定在何时使用何种算法。
	 * 在什么情况下使用什么算法是由客户端决定的。 认识策略模式 策略模式的重心
	 * 
	 */
}
