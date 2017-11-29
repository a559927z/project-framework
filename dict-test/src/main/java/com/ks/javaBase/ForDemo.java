package com.ks.javaBase;

/**
 * break 跳走，不再走剩下i++<br/>
 * continue跳走本次代码块
 * 
 * @author jxzhang on 2017年11月7日
 * @Verdion 1.0 版本
 */
public class ForDemo {

	// 0 1 2
	private static void test1() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			if (i == 2) {
				break;
			}
		}
	}

	private static void test2() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			if (i == 2) {
				System.out.println("等于2");
				continue;
			}
		}
	}

	public static void main(String[] args) {
		test2();
	}
}
