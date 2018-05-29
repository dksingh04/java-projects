package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExFindMethodWithIndex {

	public static void main(String[] args) {
		testFindMethodWithSpecificIndex();
	}
	
	public static void testFindMethodWithSpecificIndex(){
		String regex="keep";
		String input="keepkeep and keep learning";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		matcher.find(4); // find with specified index number
		System.out.println("Start Index: "+matcher.start());
		System.out.println("End Index: "+matcher.end());
		
		matcher.find(4); // find with specified index number
		System.out.println("Start Index: "+matcher.start());
		System.out.println("End Index: "+matcher.end());
		
		matcher.find(8); // find with specified index number
		System.out.println("Start Index: "+matcher.start());
		System.out.println("End Index: "+matcher.end());
		
	}
}
