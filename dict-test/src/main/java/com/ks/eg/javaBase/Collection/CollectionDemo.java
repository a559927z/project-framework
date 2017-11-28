package com.ks.eg.javaBase.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.alibaba.dubbo.common.utils.CollectionUtils;

/**
 * List.get(n) 取值最大是size-1
 * 
 * 
 * @author jxzhang on 2017年11月8日
 * @Verdion 1.0 版本
 */
public class CollectionDemo {

	/**
	 * List.get(n) 取值最大是size-1
	 */
	private static void listMaxIndexTest() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		System.out.println(arr.get(3)); // Error
	}

	/**
	 * 集合范围里随机取值
	 */
	private static void getRandomValueTest() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		int max = arr.size();
		int min = 0;
		Random r = new Random();
		// 随机取值50次
		for (int i = 0; i < 50; i++) {
			int index = r.nextInt(max) % (max - min + 1) + min;
			System.out.println(arr.get(index));
		}
	}

	/**
	 * 集合范围里随机取值
	 */
	private static void getRandomValue2Test() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		Random r = new Random();
		// 随机取值50次
		for (int i = 0; i < 50; i++) {
			int index = r.nextInt(arr.size());
			Integer rs = arr.get(index);
			System.out.println(rs);
		}
	}

	/**
	 * 集合基本类型-排序
	 */
	private static void listSimpleSortTest() {
		// ArrayList<BaseDto> ls1 = new ArrayList<BaseDto>();
		// ls1.add(new BaseDto("222", "bbb"));
		// ls1.add(new BaseDto("111", "aaa"));
		// ls1.add(new BaseDto("333", "ccc"));
		// List<BaseDto> sort = CollectionUtils.sort(ls1);
		// for (BaseDto baseDto : sort) {
		// System.out.println(baseDto.getK());
		// }
		List<String> ls1 = Arrays.asList("222", "111", "333");
		List<String> sort = CollectionUtils.sort(ls1);
		for (String str : sort) {
			System.out.println(str);
		}
	}

	/**
	 * 集合基本类型-去重
	 */
	private static void listDistincTest() {
		List<String> ls = Arrays.asList("A", "B", "A");

		Set<String> sets = new HashSet<String>(ls);
		for (String set : sets) {
			System.out.println(set);
		}
	}

	public static void main(String[] args) {
		getRandomValue2Test();
	}
}
