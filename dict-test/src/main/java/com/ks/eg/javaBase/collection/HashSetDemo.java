package com.ks.eg.javaBase.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
	
	
	

	public static void main(String[] args) {
		List<String> ls = Arrays.asList("A", "B", "A");

		Set<String> sets = new HashSet<>(ls);
		for (String set : sets) {
			System.out.println(set);
		}
	}
}
