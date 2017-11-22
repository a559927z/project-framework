package com.ks.eg.javaBase;

//swich 支持字符串
//break 跳出本次switch， 不走default，跳不出for
//return 跳出本次switch， 不走default, 跳出for
//条件符合后，不添加break return， 走default
//条件不符合后，不添/添加break return， 走default

public class SwichDemo {

	// "A"
	public static void test1() {
		switch (1) {
		case 1:
			System.out.println("A");
			break;

		default:
			System.out.println("B");
			break;
		}
	}

	// "A"
	public static void test2() {
		switch (1) {
		case 1:
			System.out.println("A");
			return;

		default:
			System.out.println("B");
			return;
		}
	}

	// "A B"
	public static void test3() {
		switch (1) {
		case 1:
			System.out.println("A");
		default:
			System.out.println("B");
			return;
		}
	}

	// "A B C def"
	public static void test4() {
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
			case 3:
				System.out.println("C");
			default:
				System.out.println("def");
				return;
			}
		}
	}

	// "A"
	public static void test5() {
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:
				System.out.println("A");
				return;
			case 2:
				System.out.println("B");
			case 3:
				System.out.println("C");
			default:
				System.out.println("def");
				return;
			}
		}
	}

	// "A"
	public static void test6() {
		String i = "A";
		switch (i) {
		case "A":
			System.out.println("A");
			break;
		case "B":
			System.out.println("B");
			break;
		default:
			System.out.println("def");
			break;
		}
	}

	// "A rs"
	public static String test7() {
		String i = "A";
		switch (i) {
		case "A":
			System.out.println("A");
			break;
		case "B":
			System.out.println("B");
			break;
		default:
			System.out.println("def");
			break;
		}
		return "rs";
	}

	// "A B C"
	public static void test8() {
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			case 4:
				System.out.println("D");
				break;
			}
		}
	}

	// "D D D"
	public static void test9() {
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 5:
				System.out.println("A");
				break;
			case 6:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
				break;
			}
		}
	}

	public static void main(String[] args) {
		test9();
		// String test7 = test7();
		// System.out.println(test7);
	}
}
