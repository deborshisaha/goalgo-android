package com.algorithms.string;

/*
Leet Code 408

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.

 */
public class AbbreviationChecker {

    public boolean isValidWordAbbreviation(String word, String possibleAbbreviation) {

        if (possibleAbbreviation.length() == 0 && word.length() == 0) {
            return true;
        }

        if (possibleAbbreviation.length() == 0) {
            return false;
        }

        for (int i = 0, j = 0; i < word.length() && j < possibleAbbreviation.length(); ) {
            if (word.charAt(i) == possibleAbbreviation.charAt(j)) {
                i++;
                j++;
            } else if ((possibleAbbreviation.charAt(j) >= '0') && (possibleAbbreviation.charAt(j) <= '9')) {

                Integer number = 0;

                while ((possibleAbbreviation.charAt(j) >= '0') && (possibleAbbreviation.charAt(j) <= '9')) {
                    number = (number * 10) + Character.getNumericValue(possibleAbbreviation.charAt(j));
                    j++;
                }

                i += number;
            } else {
                return false;
            }
        }

        return true;
    }
    
    static public void driver() {
        AbbreviationChecker abbreviationChecker = new AbbreviationChecker();
        System.out.println(abbreviationChecker.isValidWordAbbreviation("word", "1ord")?"true":"false");
        System.out.println(abbreviationChecker.isValidWordAbbreviation("internationalization", "i12iz4n")?"true":"false");
    }
}
