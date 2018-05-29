package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExLookingAtMatchesDifferent {

	public static void main(String[] args) {
		testLookingAtAndMatches();
	}
	
	public static void testLookingAtAndMatches(){
		String regex="keep";
		String input="keepkeep and keep learning";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("matches(): "+matcher.matches());
		
		System.out.println("lookingAt(): "+matcher.lookingAt());
		System.out.println("start Index: "+matcher.start());
		System.out.println("End Index: "+matcher.end());
		
		
	}
}
