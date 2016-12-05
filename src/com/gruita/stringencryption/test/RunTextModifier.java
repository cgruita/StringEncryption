package com.gruita.stringencryption.test;

/**


1. Each word in the input string is replaced with the following: the first letter of the word, the count of
distinct letters between the first and last letter, and the last letter of the word. For
example, “Automotive parts" would be replaced by "A6e p3s".

2. A "word" is defined as a sequence of alphabetic characters, delimited by any non-alphabetic
characters.

3. Any non-alphabetic character in the input string should appear in the output string in its original
relative location.


 
 * @author cgruita
 *
 */
public class RunTextModifier {

	public static void main(String[] args) {
		 	String rawString = "Aabc3abcZ,,is.a&current/string-";

			

			String result = new TextModifier().modify(rawString);
			System.out.printf("Text: %s. Result: %s", rawString, result);

			

			result = new TextModifierRegex().modify(rawString);
			System.out.printf("\nText: %s. Regex:  %s", rawString, result);

	}

}
