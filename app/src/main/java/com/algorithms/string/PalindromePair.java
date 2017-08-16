/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dsaha
 */
public class PalindromePair {
    
    ArrayList<String> arrayOfStrings = null;
    
    PalindromePair(ArrayList<String> arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }
    
    List<List<Integer>> getPairs() {
        
        HashMap<String, Integer> map = new HashMap();
        // Create a map
        int j=0;
  
        List<List<Integer>> pairs = new ArrayList();
 
        for (String string: arrayOfStrings) {map.put(string,j);j++;}
        
        int wordIterator = 0;

        for (String str: arrayOfStrings) {
            for (int i=0; i<str.length();i++) {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i);
                
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.getOrDefault(str2rvs, wordIterator) != wordIterator) 
                        pairs.add(Arrays.asList(map.get(str2rvs), wordIterator));
                }
                
                
                if (isPalindrome(str2) && str2.length()!=0) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.getOrDefault(str1rvs, wordIterator) != wordIterator) 
                        pairs.add(Arrays.asList(map.get(str1rvs), wordIterator));
                    
                }
            }
            
            wordIterator++;
        }
 
        return pairs;
    }
 
    static public void driver() {
        
        ArrayList<String> array = new ArrayList();
        array.add("cat");
        array.add("bobcat");
        array.add("tacbo");
        PalindromePair palindromePair = new PalindromePair(array);
        List<List<Integer>> pairs = palindromePair.getPairs();

        for (List<Integer> pair: pairs) {
            System.out.println(array.get(pair.get(0))+" "+array.get(pair.get(1)));
        }
    }
    
    private boolean isPalindrome(String str) {
        for (int l = 0, r = str.length() - 1; l <= r; l ++, r --) 
            if (str.charAt(l) != str.charAt(r)) return false;
        return true;
    }
}
