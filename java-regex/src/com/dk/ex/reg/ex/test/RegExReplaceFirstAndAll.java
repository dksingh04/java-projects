package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceFirstAndAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testReplaceFirstAndAll();
	}
	public static void testReplaceFirstAndAll(){
		String regex="keep";
		String input="keep keep learning";
		String replaceText = "yes";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("replaceFirst(): "+matcher.replaceFirst(replaceText));
		System.out.println("replaceAll(): "+matcher.replaceAll(replaceText));
	}

}
