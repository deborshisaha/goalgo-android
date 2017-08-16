package com.algorithms.string;

import java.util.HashMap;

/**
 *
 * @author dsaha
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithKDistinctCharacters {
    
    String text = null;
    int k = -1;
 
    public LongestSubstringWithKDistinctCharacters (String text, int k) {
        this.text = text;
        this.k = k;
    }

    private int subString() {
    
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < this.text.length(); i++) {
            
            Character c = this.text.charAt(i);
            
            if (map.containsKey(c)) {
                // This is not a new distinct character. Record and keep moving
                map.put(c, map.get(c)+1);
            } else {
                // THis is a new distinct character. Store and process
                map.put(c,1);
                
                while (map.size() > this.k) {
                   // start checking the string
                   Character ch = this.text.charAt(start);
                   if (map.get(ch)>1) {
                       map.put(ch, map.get(ch)-1);
                   } else {
                       map.remove(ch);
                   }
                   start++;
                }
            }
            
            maxLength = Math.max(maxLength, i - start + 1);
        }
        
        return maxLength;
    }
    
    static public void driver() {
        LongestSubstringWithKDistinctCharacters longestSubstringWithKDistinctCharacters = new LongestSubstringWithKDistinctCharacters("bbcebdddf", 3);
        System.out.println(longestSubstringWithKDistinctCharacters.subString());
    }
}
