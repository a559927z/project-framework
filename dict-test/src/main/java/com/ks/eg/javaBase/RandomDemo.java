package com.ks.eg.javaBase;

import java.util.Random;

public class RandomDemo {

	/**
	 * random.nextInt(max)表示生成[0,max]之间的随机数，然后对(max-min+1)取模。
	 * 
	 * 以生成[10,20]随机数为例，首先生成0-20的随机数，然后对(20-10+1)取模得到[0-10]之间的随机数，然后加上min=10，最后生成的是10-20的随机数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 20;
		int min = 10;
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(s);
	}
}
