package com.gruita.stringencryption.test;

/**
 * Modifies the text by adding each character individually, separating 
 * alphabetic from non alphabetic words as they are formed
 * 
 * @author cgruita
 *
 */
public class TextModifier {
	
	/* holds current alphabetic word */
	private  StringBuffer sbCurrentAlphabeticWord = null;
	
	/* holds current non alphabetic word */
	private  StringBuffer sbCurrentNonAlphabeticWord = null;
	
	/* holds the result */
	private  StringBuffer sbResult = null;

	/**
	 * Goes through a string character by character and retrieved the modified text according to 
	 * the rules above
	 * 
	 * @param input
	 * 		Text to be changed
	 * @return
	 * 		Changed text
	 */
	public  String modify(String input) {
		if (input == null || input.length() == 0) {
			return "";
		}

		char[] inputCharArray = input.toCharArray();
		if(inputCharArray.length > 0){
			sbCurrentAlphabeticWord = new StringBuffer();
			sbCurrentNonAlphabeticWord = new StringBuffer();
			sbResult = new StringBuffer();
		}
		for (char c : inputCharArray) {
			if (isAlphabetic(c)) {
				addToResultAndClear(sbCurrentNonAlphabeticWord, false);
				sbCurrentAlphabeticWord.append(c);
			} else { // non-alphabet character

				if (sbCurrentAlphabeticWord.length() > 0) {
					addToResultAndClear(sbCurrentAlphabeticWord, true);
				}
				sbCurrentNonAlphabeticWord.append(c);

			}
		}

		if (sbCurrentAlphabeticWord.length() > 0) {
			addToResultAndClear(sbCurrentAlphabeticWord, true);
		}
		if (sbCurrentNonAlphabeticWord.length() > 0) {
			addToResultAndClear(sbCurrentNonAlphabeticWord, false);
		}

		String result = sbResult.toString();
		sbResult.setLength(0);
		return result;
	}

	/**
	 * Checks if a character is alphabetic or not. 
	 * Digits are not considered alphabetic
	 * @param c
	 * 		the character to be checked
	 * @return
	 * 		true if alphabetic, false if not
	 */
	private static boolean isAlphabetic(char c) {
		boolean isUpperCase = Character.isUpperCase(c);
		boolean isLowerCase = Character.isLowerCase(c);
		return isUpperCase || isLowerCase;
	}

	
	/**
	 * Adds the content of the stringbuffer to the main result and then clears it
	 * @param sb
	 * 		the string buffer to be added and cleared
	 * @param isWord
	 * 		whether the stringbuffer is of type alphabetic or not
	 */
	private void addToResultAndClear(StringBuffer sb, boolean isWord) {
		if (isWord) {
			AlphabeticalWord crtAlphabeticalWord = new AlphabeticalWord(sb.toString());
			String crtWordResult = crtAlphabeticalWord.getResult();
			if (crtWordResult == null) {
				crtWordResult = "";
				System.out.println("Warning, word result is null, changing to empty string");
			}
			sbResult.append(crtWordResult);
		} else {
			sbResult.append(sb.toString());
		}

		sb.setLength(0);
	}

	
}
