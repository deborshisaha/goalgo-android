/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.dp;

import java.util.HashSet;

public class WordsColaesced {

    public static void driver() {
        WordsColaesced obj = new WordsColaesced();

        HashSet<String> set = new HashSet();
        set.add("i");
        set.add("a");
        set.add("am");
        set.add("ace");
        String target = "iamace";
        System.out.println(target+" colaesced? " + obj.areWordsColaesced(target, set));
    }

    public boolean areWordsColaesced(String target, HashSet<String> dictionary) {

        boolean[][] T = new boolean[target.length()][target.length()];

        for (int len = 1; len <= target.length(); len++) {
            //System.out.println("Length:"+ len);
            for (int i = 0; i + len < target.length()+1; i++) {

                String substring = target.substring(i, i + len);
                //System.out.println();
                //System.out.print(substring+" "+ i+":"+(i+len));
                if (dictionary.contains(substring)) {
                    //System.out.print(" in dictionary ");
                    T[i][i + len-1] = true;
                    //System.out.println();
                    continue;
                }
                if (len == 1) {continue;}
                for (int k = i; k < i + substring.length(); k++) {
                    if (T[i][k] && T[k + 1][i + substring.length()-1]) {
                        T[i][i + len-1] = true;
                        //System.out.print(" in dictionary ");
                        break;
                    } else {
                        T[i][i + len-1] = false;
                    }
                    
                }
                
                //System.out.println();
            }

        }

        return T[0][target.length() - 1];
    }
}
