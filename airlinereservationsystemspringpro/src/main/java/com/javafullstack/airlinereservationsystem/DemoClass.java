package com.javafullstack.airlinereservationsystem;

import java.util.regex.Pattern;

public class DemoClass {
	public static void main(String[] args) {
		String ptrn = "[A-Za-z]*";
		
		Pattern pattern = Pattern.compile(ptrn);
		
		System.out.println(pattern.matcher("1Abcd").matches());
	}
}
