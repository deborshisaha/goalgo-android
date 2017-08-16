package com.algorithms.recursion;

/**
 * Assumption :- get(int number) characters for that number
 */
public class WordsPossibleUsingAPhoneNumber {

    void permute(String string, char[] ph, int position) {

        if (position >= ph.length) {
            // Check in a dictionary
            // If a word, then put in a dictionary
            System.out.println(string);
            return;
        }

        char digit = ph[position];

        char[] characters = getCharactersForDigit(digit);

        for (int i = 0; i < characters.length; i++) {
            
            if (characters[i]=='+') {
                permute(string, ph, position + 1);;
            } else {
                permute(string + characters[i], ph, position + 1);
            }
        }
    }

    private char[] getCharactersForDigit(char a) {

        int digit = a - '0';

        switch (digit) {

            case 0:
                return "+".toCharArray();
            case 2:
                return "abc".toCharArray();
            case 3:
                return "def".toCharArray();
            case 4:
                return "ghi".toCharArray();
            case 5:
                return "jkl".toCharArray();
            case 6:
                return "mno".toCharArray();
            case 7:
                return "pqrs".toCharArray();
            case 8:
                return "tuv".toCharArray();
            case 9:
                return "wxyz".toCharArray();
            default:
                return "_".toCharArray();
        }

    }

    public static void driver() {
        WordsPossibleUsingAPhoneNumber obj = new WordsPossibleUsingAPhoneNumber();
        
        String phone = "4156831968";
        String[] phoneSplit = phone.split("1");
        
        for (String s: phoneSplit) {
            obj.permute("", s.toCharArray(), 0);
        }
        
    }
}
