package com.dk.ex.reg.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPatternUtility {

	/**
	 * Allow only set of Special Character and not other characters. which does
	 * not contains any other character in the String.
	 */

	/**
	 * 
	 * @param pattern
	 * @param data
	 * @return boolean
	 * 
	 * You can modify this method as per your need. For example you can
	 * pass set of character as an another parameter to which you don't
	 * want to consider e.g. containsOnlySpecificCharacter(String
	 * pattern, String excludeStrPattern, String data)
	 * 
	 * So this method will return true only when data will contains
	 * characters from the pattern list.
	 * 
	 */
	public static boolean containsOnlySpecificCharacter(String pattern,
			String data) {

		Pattern specialCharPattern = Pattern.compile(pattern);
		Matcher spclCharMatcher = specialCharPattern.matcher(data);
		Pattern otherCharPattern = Pattern
				.compile("[a-zA-Z0-9<>`~'(){}\\[\\]]");
		Matcher otherCharMatcher = otherCharPattern.matcher(data);
		return (spclCharMatcher.find() && !otherCharMatcher.find());
	}
	
		
	public static boolean isMatchExist(String pattern, String data){
		Pattern patternData = Pattern.compile(pattern);
		Matcher matcher = patternData.matcher(data);
		return matcher.find();
		
		/**
		 * The above code can be writen in single line 
		 * Pattern.matches(pattern, data);
		 */
	}
	
	
	

}
