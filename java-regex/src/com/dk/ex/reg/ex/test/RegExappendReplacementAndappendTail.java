package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExappendReplacementAndappendTail {

	public static void main(String[] args) {
		testAppendReplaceAndTail();
	}
	
	public static void testAppendReplaceAndTail(){
		String regex="not";
		String input="notkeepnotkeepnotlearning";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		StringBuffer buffer = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(buffer, " "); // remove not with space.
		}
		matcher.appendTail(buffer);
		System.out.println("Replaced Text: "+buffer.toString());
	}

}
