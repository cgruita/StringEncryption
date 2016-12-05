package com.gruita.stringencryption.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Modfies the text by splitting the text first using regular expressions
 * 
 * @author cgruita
 *
 */
public class TextModifierRegex {

	/* holds non alphabetical words */
	private StringBuffer sbNonAlphabeticalWords = null;
	
	/* holds result */
	private StringBuffer sbResult = null;

	/* regext expression for finding the alphabetical words. Digits are not considered alphabetical */
	private final static Pattern p = Pattern.compile("([a-zA-Z]*)");

	
	/**
	 * changes the text according to the rules above
	 * @param line
	 * 		input text to be changed
	 * @return
	 * 		changed text
	 */
	public String modify(String line) {
		
		Matcher m = p.matcher(line);
		int firstMatchPos = 0;

		while (m.find()) {
			if (sbResult == null) {
				sbResult = new StringBuffer();
			}
			String stringMatch = m.group(1);
			if (stringMatch != null && stringMatch.length() != 0) {

				// non words from previous iterations
				addToResultAndClear();

				// words
				AlphabeticalWord crtWord = new AlphabeticalWord(stringMatch);
				String codedWord = crtWord.getResult();
				sbResult.append(codedWord);
			} else {
				firstMatchPos = m.start();
				if (firstMatchPos < line.length()) {
					char c = line.charAt(firstMatchPos);
					if(sbNonAlphabeticalWords == null){
						sbNonAlphabeticalWords = new StringBuffer();
					}
					sbNonAlphabeticalWords.append(c);
				}
			}

		}
		addToResultAndClear();		
		return sbResult.toString();
	}

	/**
	 * Adds non-word stringbuffer to the result and then clears it
	 */
	private void addToResultAndClear() {
		if (sbNonAlphabeticalWords == null) {
			sbNonAlphabeticalWords = new StringBuffer();
		} else {
			if (sbNonAlphabeticalWords.length() > 0) {
				String nonWord = sbNonAlphabeticalWords.toString();
				if (nonWord != null && nonWord.length() != 0) {
					sbResult.append(nonWord);
					sbNonAlphabeticalWords.setLength(0);
				}
			}
		}

	}
	
	


}
