package com.ks.eg.javaBase.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ks.eg.BaseDto;

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

	private static void test3() {
		ArrayList<BaseDto> ls1 = new ArrayList<BaseDto>();
		ls1.add(new BaseDto("222", "bbb"));
		ls1.add(new BaseDto("111", "aaa"));
		ls1.add(new BaseDto("333", "ccc"));
		 List<BaseDto> sort = CollectionUtils.sort(ls1);
		 for (BaseDto baseDto : sort) {
		 System.out.println(baseDto.getK());
		 }

	}

	public static void main(String[] args) {
		test3();
	}
}
