import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConvertDigitToWords {
	private Scanner keyboard;
	private Map<Character, String> onedigitMap = new HashMap<Character, String>();
	private Map<String, String> twodigitMap = new HashMap<String, String>();
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String MILLION = "million";
	private static final String SPACE = " ";
	private List<String> list = new ArrayList<String>();
	Integer inputNumber;
	String outputValue = "";

	public ConvertDigitToWords() {
		InitializeTheMappingValues();
		keyboard = new Scanner(System.in);
	}

	public void InitializeTheMappingValues() {
		onedigitMap.put('1', "one");
		onedigitMap.put('2', "two");
		onedigitMap.put('3', "three");
		onedigitMap.put('4', "four");
		onedigitMap.put('5', "five");
		onedigitMap.put('6', "six");
		onedigitMap.put('7', "seven");
		onedigitMap.put('8', "eight");
		onedigitMap.put('9', "nine");

		twodigitMap.put("11", "eleven");
		twodigitMap.put("12", "twelve");
		twodigitMap.put("13", "thirteen");
		twodigitMap.put("14", "fourteen");
		twodigitMap.put("15", "fifteen");
		twodigitMap.put("16", "sixteen");
		twodigitMap.put("17", "seventeen");
		twodigitMap.put("18", "eighteen");
		twodigitMap.put("19", "ninteen");

		twodigitMap.put("10", "ten");
		twodigitMap.put("20", "twenty");
		twodigitMap.put("30", "thirty");
		twodigitMap.put("40", "fourty");
		twodigitMap.put("50", "fifty");
		twodigitMap.put("60", "sixty");
		twodigitMap.put("70", "seventy");
		twodigitMap.put("80", "eighty");
		twodigitMap.put("90", "ninty");

	}

	public void readInput() {
		inputNumber = keyboard.nextInt();
		if (inputNumber < 1 || inputNumber > 999999999) {
			System.out.println("Invalid Number");
		}
	}
/**
 * Complete logic is here
 */
	public void convertDigitInWords() {
		NumberFormat nmf = NumberFormat.getInstance();
		String commaSepratedVaString = nmf.format(inputNumber);
		System.out.println(commaSepratedVaString);
		String[] splittedVal = commaSepratedVaString.split(",");
		boolean check = false;
		for (int i = splittedVal.length - 1; i >= 0; i--) {
			String val = splittedVal[i];
			int len = val.length();
			switch (len) {
			case 1:
				list.add(onedigitMap.get(val.toCharArray()[0]));
				break;
			case 2:
				outputValue = getStringValueForTwoDigit(val, 2);
				list.add(outputValue);
				break;
			case 3:
				String lastTwoDig = "";
				for (int j = val.length() - 1; j >= 0; j--) {
					if ('0' != val.charAt(j)) {
						lastTwoDig = getStringValueForTwoDigit(val, 3);
						lastTwoDig = (val.charAt(val.length() - 3) != '0' ? onedigitMap
								.get(val.charAt(val.length() - 3))
								+ SPACE + HUNDRED + SPACE
								: "")
								+ (lastTwoDig != null ? lastTwoDig : "");
						list.add(lastTwoDig);
						check = true;
						break;
					}
				}
				if (!check)
					list.add("");
				break;
			}
		}
		InitializeListWithNullValue();
	}
/**
 * Created to solve the display problem 
 */
	public void InitializeListWithNullValue() {
		int size = list.size();
		if (size == 0 || size < 3) {
			do {
				list.add("");
				size = list.size();
			} while (size != 3);
		}
	}
/**
 * Logic to generate words for two digit numbers.
 */
	
	public String getStringValueForTwoDigit(String val, int len) {
		Integer tempVal = new Integer("" + val.charAt(len - 2)
				+ val.charAt(len - 1));
		String tempDigVal = "";

		if (tempVal < 21 && tempVal >= 10) {
			tempDigVal = twodigitMap.get(tempVal.toString());
		} else {
			String twoDigVal = "" + val.charAt(len - 2) + '0';
			tempDigVal = (twodigitMap.get(twoDigVal) != null ? twodigitMap
					.get(twoDigVal) : "")
					+ (val.charAt(len - 1) != '0' ? onedigitMap.get(val
							.charAt(len - 1)) : "");
		}
		return tempDigVal;
	}

	public void displayOutput() {
		outputValue = (!list.get(2).equals("") ? list.get(2) + SPACE + MILLION
				+ SPACE : "")
				+ (!list.get(1).equals("") ? list.get(1) + SPACE + THOUSAND
						+ SPACE : "") + list.get(0);
		System.out.println(inputNumber + " ==> " + outputValue);
	}

	public static void main(String[] args) {
		ConvertDigitToWords cdw = new ConvertDigitToWords();
		cdw.readInput();
		cdw.convertDigitInWords();
		cdw.displayOutput();
	}

}
