package com.algorithms.string;

/**
 *
 * @author dsaha
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMPSubstringSearch {
    
    String pattern = null;
    String targetString = null;
    
    private KMPSubstringSearch(String pattern, String targetString) {
        this.pattern = pattern;
        this.targetString = targetString;
    }

    public boolean hasSubstring() {
        
        // Pre compute array
        int[] processedArray = precomputedArray();
        
        int i=0, p=0;
        
        for (; i< this.targetString.length() && p < this.pattern.length(); ) {
            
            if (this.targetString.charAt(i) == this.pattern.charAt(p)) {
                i++;
                p++;
            } else {
                if (p!=0) {
                    p = processedArray[p-1];
                } else {
                    i++;
                }
            }
        }
        
        if (p == this.pattern.length()) {
            return true;
        }
        
        return false;
    }
    
    int[] precomputedArray() {
        
        int[] computedArray = new int[this.pattern.length()];
        
        if (computedArray.length > 0) {
            computedArray[0] = 0;
        }
        
        for (int i=0, j=1; j < this.pattern.length();) {
            
            if (this.pattern.charAt(i) == this.pattern.charAt(j)) {
                computedArray[j] = i+1;
                j++;
                i++;
            } else {
                
                if (i!=0) {
                    int gotoIdx = i-1;
                    if (gotoIdx < 0) {
                        gotoIdx = 0;
                    }
                    i = computedArray[gotoIdx];
                } else {
                    computedArray[i] = 0;
                    j++;
                }
            }
        }
        
        for (int i=0; i<computedArray.length;i++) {
            System.out.print(computedArray[i]+",");
        }
        
        System.out.println();
        
        return computedArray;
    }
 
    static public void driver() {
        String targetString = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        KMPSubstringSearch KMP = new KMPSubstringSearch(pattern, targetString);
        
        System.out.println(KMP.hasSubstring()?"true":"false");
    }
}
