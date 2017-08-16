package com.algorithms.dp;

public class StringInterleaving {

    String str1 = null;
    String str2 = null;
    String target = null;

    public static void driver() {
        StringInterleaving obj = new StringInterleaving("aab", "axy", "aaabx");
        System.out.println("Is interleaved: " + obj.isInterleaved());
    }

    public StringInterleaving(String string1, String string2, String target) {
        this.str1 = string1;
        this.str2 = string2;
        this.target = target;
    }

    public boolean isInterleaved() {

        boolean[][] T = new boolean[this.str1.length() + 1][this.str2.length() + 1];

        for (int r = 0; r <= str1.length(); r++) {
            for (int c = 0; c <= str2.length(); c++) {
                T[r][c] = false;
            }
        }

        T[0][0] = true;

        for (int c = 1; c <= str2.length(); c++) {
            T[0][c] = (target.charAt(c - 1) == str2.charAt(c - 1));
        }

        for (int r = 1; r <= str1.length(); r++) {
            T[r][0] = (target.charAt(r - 1) == str1.charAt(r - 1));
        }

        for (int r = 1; r <= str1.length(); r++) {
            for (int c = 1; c <= str2.length(); c++) {
                
                if (!(r+c-1 > target.length())) {
                    break;
                }
                
                char ch = target.charAt(r + c-1);

                if ((ch == str1.charAt(c - 1) && ch == str2.charAt(r - 1))
                        || (ch == str1.charAt(c - 1) && T[r][c - 1])
                        || (ch == str2.charAt(r - 1) && T[r - 1][c])) {
                    T[r][c] = true;
                } else {
                    T[r][c] = false;
                }
            }
        }

        return T[this.str1.length()][this.str2.length()];
    }
}
