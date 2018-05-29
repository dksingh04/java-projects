package com.dk.ex.reg.ex.test;

public class RegExExample {

	public static void main(String[] args) {
		//testcontainsOnlySpecificChar();
		intersection();
		testcontainsOnlySpecificChar();
	}

	public static void testcontainsOnlySpecificChar() {
		// Print false because it contains other character e.g. alphabets
		System.out.println(RegExPatternUtility.containsOnlySpecificCharacter(
				"[#$%/\\^*,.-_+=:;?@!]", "Dee!@pak"));
		// Print true, because data contains only expected characters.
		System.out.println(RegExPatternUtility.containsOnlySpecificCharacter(
				"[#$%/\\^*,.-_+=:;?@!]", "!*"));
		System.out.println(RegExPatternUtility.containsOnlySpecificCharacter(
				"[#$%/\\^*,.-_+=:;?@!]", "+_-;!*"));
		// Print false, because data contains numbers.
		System.out.println(RegExPatternUtility.isMatchExist(
				"[#$%/\\^*,.-_+=:;?@![sddf]]", "!* - @"));
	}

	public static void testStringStartOrEndWithNumber() {
		/**
		 * To test string start with number the pattern should be ^[0-9]
		 * Character (^) indicate the beginning of line.
		 */
		// true
		System.out.println("1 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]", "123string"));
		// false
		System.out.println("2 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]", "string123"));

		/**
		 * What if you want to check string containing number at end of the
		 * string Character ($) indicate the end of line, so we have to use $
		 * here so regex will look like [0-9]$
		 */

		// false
		System.out.println("3 : "
				+ RegExPatternUtility.isMatchExist("[0-9]$", "123string"));
		// true
		System.out.println("4 : "
				+ RegExPatternUtility.isMatchExist("[0-9]$", "string123"));

		/**
		 * What if you want to check string containing numbers exactly N times
		 * either at start or end of the string. You can use \d instead of
		 * [0-9]. You can use different other pattern for matching X{n} X,
		 * exactly n times X{n,} X, at least n times X{n,m} X, at least n but
		 * not more than m times
		 */

		// true
		System.out.println("5 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}", "123string"));
		// false
		System.out.println("6 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}", "12string"));
		// false numbers ar at the end.
		System.out.println("7 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}", "string123"));

		// false
		System.out.println("8 : "
				+ RegExPatternUtility.isMatchExist("\\d{3}$", "123string"));
		// true
		System.out.println("9 : "
				+ RegExPatternUtility.isMatchExist("\\d{3}$", "string123"));
		// false.
		System.out.println("10 : "
				+ RegExPatternUtility.isMatchExist("\\d{3}$", "string23"));
	}

	public static void testStringStartOrEndWithNumbersInSinglePattern() {
		// true
		System.out.println("1 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}|[0-9]{3}$",
						"123string123"));
		// true
		System.out.println("2 : "
				+ RegExPatternUtility.isMatchExist("^\\d{3}|\\d{3}$",
						"123string"));
		// true
		System.out.println("3 : "
				+ RegExPatternUtility.isMatchExist("^\\d{3}|\\d{3}$",
						"string123"));
		// false.
		System.out.println("4 : "
				+ RegExPatternUtility.isMatchExist("^\\d{3}|\\d{3}$",
						"str123ing"));
		// false.
		System.out.println("5 : "
				+ RegExPatternUtility.isMatchExist("^\\d{3}|\\d{3}$",
						"12string12"));
	}

	public static void testStringStartAndEndWithNumbers() {
		// true
		System.out.println("1 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"123string123"));
		// false
		System.out.println("2 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"12string123"));
		// false
		System.out.println("3 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"123string12"));

		// false
		System.out.println("4 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"123string"));
		// false
		System.out.println("5 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"123123"));
		// false
		System.out.println("6 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"string123"));
		// true
		System.out.println("7 : "
				+ RegExPatternUtility.isMatchExist("^[0-9]{3}\\w+[0-9]{3}$",
						"1234string1234"));

	}

	/**
	 * Similar manner you can search for data starting or ending with text.
	 * 
	 */
	
	/**
	 * Intersection of character sets. For example in a-z character set 
	 * you want to return true only when certain character is there in the String
	 * for example you want to return true when d, e or f is there in the character set.
	 * 
	 * You can use Reg-ex [a-z&&[def]]
	 */
	
	public static void intersection(){
		// true 
		System.out.println("1 : "
				+ RegExPatternUtility.isMatchExist("[a-z&&[def]]",
						"abcd"));
		//false
		System.out.println("2 : "
				+ RegExPatternUtility.isMatchExist("[a-z&&[def]]",
						"abc"));
	}

}
