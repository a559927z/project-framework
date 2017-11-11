package com.ks.eg.javaBase.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List.get(n) 取值最大是size-1
 * 
 * 
 * @author jxzhang on 2017年11月8日
 * @Verdion 1.0 版本
 */
public class CollectionDemo {

	private static void test1() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		System.out.println(arr.get(3)); // Error
	}

	// 集合范围里随机取值
	private static void test2() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		int max = arr.size();
		int min = 0;
		Random r = new Random();
		// 随机取值50次
		for (int i = 0; i < 50; i++) {
			int rs = r.nextInt(max) % (max - min + 1) + min;
			System.out.println(rs);
		}

	}

	public static void main(String[] args) {
		test2();
	}
}
