package com.gruita.stringencryption.test;


import java.util.HashSet;
import java.util.Set;

/**
 * Word that is alphabetic, will be changed according to the rules defined in the test program 
 * @author cgruita
 *
 */
public class AlphabeticalWord {
	
		
	private Set<Character> setUniqueCharacters = null;
	private String inputString;
	
	public AlphabeticalWord(String input){
		this.inputString = input;
	}
	
	public String getResult(){
		String result = "";
		
//		empty or null string
		if(inputString == null || inputString.length() == 0){
//			System.out.println("input: **" + inputString + "**, result: **" + result + "**");
			return result;
		}
		
//		string of size 1
		int initialStringLength = inputString.length();
		if(initialStringLength == 1){
			result = inputString;
//			System.out.println("input: **" + inputString + "**, result: **" + result + "**");
			return result;
		}
		
		char charFirst = inputString.charAt(0);
		char charLast = inputString.charAt(initialStringLength-1);
		String stringNoEnds = inputString.substring(1, initialStringLength-1);
//		System.out.println("reduced String: **" + reducedString + "**");
		
		char[] characters = stringNoEnds.toCharArray();
		if(characters.length > 0){
			setUniqueCharacters = new HashSet<>();
		}
		for (char c : characters) {
			Character objCharacter = Character.valueOf(c);
			if(!setUniqueCharacters.contains(objCharacter)){
				setUniqueCharacters.add(objCharacter);
			} 
		}
		int uniqueCharacters = 0;
		if(setUniqueCharacters != null && !setUniqueCharacters.isEmpty()){
			uniqueCharacters = setUniqueCharacters.size();
		}
		result = charFirst + String.valueOf(uniqueCharacters) + charLast;
//		System.out.println("input: **" + inputString + "**, result: **" + result + "**");
		return result;
	}
	

	
	
	
	

}
