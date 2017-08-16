package com.algorithms.string;

import java.util.HashSet;

/**
 *
 * @author dsaha
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:+
 * Assume the length of given string will not exceed 1,010.
 */
public class LongestPalindromeSubstring {
    
    public int longestPalindromePossible (String string) {
        
        if(string==null || string.length()==0) return 0;
        
        int length = 0;
        int count = 0;
        HashSet<Character> evenCharacterSet = new HashSet(); 
        
        for(int i=0; i<string.length(); i++) {
            Character c = string.charAt(i);
            if (evenCharacterSet.contains(c)) {
                evenCharacterSet.remove(c);
                count++;
            } else {
                evenCharacterSet.add(c);
            }
        }
        
        length = (2*count == string.length())? string.length(): (2*count+1);
   
        return length;
    }
    
    static public void driver() {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindromePossible("Aa"));
    }
}
