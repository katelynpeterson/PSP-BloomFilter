package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PspSpellCheckerApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to the Spellchecker program!");
		String fileName = "Word_dictionary.txt";
		List<String> hash = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		
		boolean goAgain = true;
		
		//read in list of words
		List<String> dictionary = SpellCheck.createDictionary(fileName);
		
		//for each word, run through MD5 to get a hash
		for(String word : dictionary)
		//for(int i = 0; i < dictionary.size(); i++) {
			hash.add(SpellCheck.md5CreateHash(word));
		
		do {
		//take a word from the user
		System.out.println("\nEnter a word for the spellchecker to check: ");
		String userWord = input.nextLine();
				
		boolean result = SpellCheck.verifyWordIsValid(SpellCheck.md5CreateHash(userWord), hash);
		
		if(result)
			System.out.println("\nYour word matches the dictionary");
		else
			System.out.println("\nYour word is not in the dictionary");
		
		//Continue searching
		System.out.println("\nWould you like to go again? Y/N");
		String response = input.nextLine();
		
		if(!response.equalsIgnoreCase("Y"))
			goAgain = false;
		}while(goAgain);
		input.close();
	}
}
