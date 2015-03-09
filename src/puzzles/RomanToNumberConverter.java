package puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * This is roman to arabic number conversion.
 * http://java.dzone.com/articles/thursday-code-puzzler-roman
 * 
 */
public class RomanToNumberConverter {
	private static Map<String, Integer> romanToDecimalMap = new HashMap<>();
	private static List<String> romanLetters;
	static {
		//some improvements
		// declare the class for roman letters and thier corresponding value.
		romanToDecimalMap.put("I", 1);
		romanToDecimalMap.put("V", 5);
		romanToDecimalMap.put("X", 10);
		romanToDecimalMap.put("L", 50);
		romanToDecimalMap.put("C", 100);
		romanToDecimalMap.put("D", 500);
		romanToDecimalMap.put("M", 1000);
		
		romanLetters = Arrays.asList("I","V","X","L","C","D","M");
		
		
	}
	public static Integer convertToArabic(String romanValue) {
		if(romanValue == null || romanValue == "") {
			return -1;
		}
		if(validate(romanValue)==false) {
			return -1;
		}
		
		Integer decimalValue = 0;
		Boolean status = false;
		char[] letters = romanValue.toCharArray();
		
		for(int i=letters.length-1 ; i>=0; i--)
		{
			Integer digit = 0;
			Character letter = letters[i];
			if(i>=1) {
				Character nextLetter = letters[i-1];
				//you can just get the value of current and next letter and check those values.
				status = compare(letter, nextLetter);
				if(status) {
					digit = calculateValue(letter,nextLetter);
					i--;
				} else {
					digit = romanToDecimalMap.get(letter.toString());
				}
			} else {
				digit = romanToDecimalMap.get(letter.toString());
			}
				decimalValue = decimalValue + digit;
		}
		return decimalValue;
	}
	
	
	private static boolean validate(String romanValue) {
		for (Character letter : romanValue.toCharArray()) {
			if(romanLetters.indexOf(letter.toString()) < 0) {
				return false;
			}
		}
		return true;
	}


	private static Integer calculateValue(Character letter, Character nextLetter) {
		Integer digit = romanToDecimalMap.get(letter.toString()) - romanToDecimalMap.get(nextLetter.toString());
		return digit;
	}

	//you can directly compare the numeral values.
	private static Boolean compare(Character current, Character next) {
		Integer indexOfCurrent = romanLetters.indexOf(current.toString());
		Integer indexOfNext = romanLetters.indexOf(next.toString());
		if(indexOfCurrent > indexOfNext) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String args[]) 
	{
		System.out.println(convertToArabic("X"));
		System.out.println(convertToArabic("XIII"));
		System.out.println(convertToArabic("XV"));
		System.out.println(convertToArabic("L"));
		System.out.println(convertToArabic("LX"));
		System.out.println(convertToArabic("DX"));
		
		
		System.out.println(convertToArabic("IV"));
		System.out.println(convertToArabic("IX"));
		System.out.println(convertToArabic("XL"));
		System.out.println(convertToArabic("L"));
		System.out.println(convertToArabic("XC"));
		System.out.println(convertToArabic("CM"));
		
		System.out.println(convertToArabic("LXXXIII"));
		System.out.println(convertToArabic("XLIX"));
		System.out.println(convertToArabic("XCIX"));
		System.out.println(convertToArabic("MDCCC"));
		
		
		System.out.println(convertToArabic(null));
		System.out.println(convertToArabic(""));
		System.out.println(convertToArabic("QQQ"));
		System.out.println(convertToArabic("XXB"));
		System.out.println(convertToArabic("CPC"));
		System.out.println(convertToArabic("XXXZ"));
		
		
	}
	
}
