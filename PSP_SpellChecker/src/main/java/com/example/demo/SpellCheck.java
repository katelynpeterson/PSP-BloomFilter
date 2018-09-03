package com.example.demo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import org.springframework.util.DigestUtils;

public class SpellCheck {
	static List<String> wordArray = Collections.emptyList(); //for creating a dictionary
	
	//see if the word is in the hash table
	public static boolean verifyWordIsValid(String userWord, List<String> hash) {
		
		for(String word : hash)	{
			if(userWord.equalsIgnoreCase(word))
				return true;
		}
		
		return false;
	}
	
	public static List<String> createDictionary(String fileName) {
		
		try
	    {
			return wordArray = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	    }catch (IOException e)
	    {	 
	      e.printStackTrace();
	      return null;
	    }
	}
	
	//Create a hash for each word
	public static String md5CreateHash(String word){
        String digest = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(word.getBytes("UTF-8"));
                  
           digest = md5Spring(hash);
          
        } catch (UnsupportedEncodingException ex) {
        	ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) { 
        	ex.printStackTrace();
        }
        return digest;
    }
	
	public static String md5Spring(byte [] byteArray){
        return DigestUtils.md5DigestAsHex(byteArray);
    }
}
