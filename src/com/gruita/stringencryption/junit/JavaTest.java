package com.gruita.stringencryption.junit;

import com.gruita.stringencryption.test.AlphabeticalWord;
import com.gruita.stringencryption.test.TextModifier;
import com.gruita.stringencryption.test.TextModifierRegex;

import junit.framework.TestCase;

public class JavaTest extends TestCase{
	
	
	
//	words
	private AlphabeticalWord emptyStringWord;
	private AlphabeticalWord nullStringWord;
	private AlphabeticalWord oneLetterStringWord;
	private AlphabeticalWord twoLetterStringWord;
	private AlphabeticalWord threeLetterStringWord;
	private AlphabeticalWord fourLetterStringWord;
	
	
	

	   // initialize objects
	   protected void setUp() throws Exception{
		   
		   emptyStringWord = new AlphabeticalWord("");
		   nullStringWord = new AlphabeticalWord(null);
		   oneLetterStringWord = new AlphabeticalWord("A");
		   twoLetterStringWord = new AlphabeticalWord("Ab");
		   threeLetterStringWord = new AlphabeticalWord("Abc");
		   fourLetterStringWord = new AlphabeticalWord("Abcd");
		   
		   oneLetterStringWord = new AlphabeticalWord("A");
		   twoLetterStringWord = new AlphabeticalWord("Ab");
		   threeLetterStringWord = new AlphabeticalWord("Abc");
		   fourLetterStringWord = new AlphabeticalWord("Abcd");
		   
	     
	   }
	   
	  
	   public void parseWords(){
		   
	      String result = emptyStringWord.getResult();
	      assertTrue(result.equals(""));
	      
	      result = nullStringWord.getResult();
	      assertTrue(result.equals(""));
	      
	      result = oneLetterStringWord.getResult();
	      assertTrue(result.equals("A"));
	      
	      result = twoLetterStringWord.getResult();
	      assertTrue(result.equals("A0b"));
	      
	      result = threeLetterStringWord.getResult();
	      assertTrue(result.equals("A1c"));
	      
	      result = fourLetterStringWord.getResult();
	      assertTrue(result.equals("A2d"));
	   }
	   
	   public void parsePhrases(){
		   
//		   incremental
		   assertTrue(new TextModifier().modify("").equals("")) ;
		   assertTrue(new TextModifier().modify("./#$%").equals("./#$%")) ;
		   assertTrue(new TextModifier().modify("...///...").equals("...///...")) ;
		   assertTrue(new TextModifier().modify("AabcdabcdefghefghabcdZ").equals("A8Z")) ;
		   assertTrue(new TextModifier().modify("AabcdabcdefghefghABCDZ").equals("A12Z")) ;
		   
		   assertTrue(new TextModifier().modify("...///aaa...").equals("...///a1a...")) ;
		   assertTrue(new TextModifier().modify("...///aaa...aaa").equals("...///a1a...a1a")) ;
		   assertTrue(new TextModifier().modify("...///aaa...aa").equals("...///a1a...a0a")) ;
		   assertTrue(new TextModifier().modify("...///aaa...aa a").equals("...///a1a...a0a a")) ;
		   
//		   digits
		   assertTrue(new TextModifier().modify("...///aa3a..3.aa a").equals("...///a0a3a..3.a0a a")) ;
		   
//		   regex
		   assertTrue(new TextModifierRegex().modify("").equals("")) ;
		   assertTrue(new TextModifierRegex().modify("./#$%").equals("./#$%")) ;
		   assertTrue(new TextModifierRegex().modify("...///...").equals("...///...")) ;
		   assertTrue(new TextModifierRegex().modify("AabcdabcdefghefghabcdZ").equals("A8Z")) ;
		   assertTrue(new TextModifierRegex().modify("AabcdabcdefghefghABCDZ").equals("A12Z")) ;
		   
		   assertTrue(new TextModifierRegex().modify("...///aaa...").equals("...///a1a...")) ;
		   assertTrue(new TextModifierRegex().modify("...///aaa...aaa").equals("...///a1a...a1a")) ;
		   assertTrue(new TextModifierRegex().modify("...///aaa...aa").equals("...///a1a...a0a")) ;
		   assertTrue(new TextModifierRegex().modify("...///aaa...aa a").equals("...///a1a...a0a a")) ;
		   
//		   digits
		   assertTrue(new TextModifier().modify("...///aa3a..3.aa a").equals("...///a0a3a..3.a0a a")) ;
		   
		   

		   // check same result for both modifiers
		   assertTrue(new TextModifier().modify("...///aaa...aa a").equals(new TextModifierRegex().modify("...///aaa...aa a"))) ;
		   assertTrue(new TextModifier().modify("...///aa3a..3.aa a").equals(new TextModifierRegex().modify("...///aa3a..3.aa a"))) ;
		   
	   }
	   
	   public void testAll(){
		   parseWords();
		   parsePhrases();

	   }
	   
	   
	   
}
