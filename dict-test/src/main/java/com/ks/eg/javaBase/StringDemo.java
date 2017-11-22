package com.ks.eg.javaBase;

import org.apache.commons.lang3.StringUtils;

public class StringDemo {

	public static void test1() {
		String a = null;
		String b = "";
		System.out.println(a + b);
	}

	public static void test2() {
		String a = null;
		String b = "";

		String join = StringUtils.join(a, b);
		System.out.println(join);
	}

	public static void main(String[] args) {
		test2();
	}
}
