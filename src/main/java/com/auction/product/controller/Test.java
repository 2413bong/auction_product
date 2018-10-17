package com.auction.product.controller;

public class Test {
	
	public static <T> T get(T t) {
		return t;
	}
	
	public static Object get1(Object o) {
		return o;
	}
	
	public static <T extends String> T get2(T t) {
		return t;
	}
	public static void main(String[] args) {
		String str = get(new String("abc"));
		Integer i = get(new Integer(1));
		
		String str1 = (String)get1(new Integer(1));
		
	}
}
