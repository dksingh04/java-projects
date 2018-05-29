package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExStartEndMethodExample {

	public static void main(String[] args) {
		testStartEndMethod();
	}
	
	public static void testStartEndMethod(){
		String regex="keep";
		String input="keepkeep and keep learning";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while(matcher.find()){
			count++;
			System.out.println("Match Number: "+count);
			System.out.println("Start Index: "+matcher.start());
			System.out.println("End Index: "+matcher.end());
		}
	}

}
