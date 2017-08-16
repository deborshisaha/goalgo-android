package com.algorithms.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainWordsToCircle {

    public static void driver() {
        ChainWordsToCircle obj = new ChainWordsToCircle();
        String[] words1 = new String[]{"ABC", "CAT", "TEA"};
        String[] words2 = new String[]{"ABC", "CE", "EATA"};

        try {
            System.out.println(obj.canChain(words2));
        } catch (NotEnoughWords ex) {
            Logger.getLogger(ChainWordsToCircle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotEnoughCharacters ex) {
            Logger.getLogger(ChainWordsToCircle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean canChain(String[] words) throws NotEnoughWords,NotEnoughCharacters {

        if (words.length < 2) {
            return false;
        }

        char ch = getLastCharacter(words, 0);

        return canChain(words, ch, 1);
    }

    private boolean canChain(String[] words, char lc, int pos) throws NotEnoughWords, NotEnoughCharacters {

        // ERror  handling 
        // happy case
        // base case
        char startCharacter = getFirstCharacter(words, pos);

        // 1. 
        if (startCharacter == lc) {
            // 2. wraps around
            char lastCharacter = getLastCharacter(words, pos);
            if (pos == (words.length - 1)) {
                char firstCharacter = getFirstCharacter(words, 0);
                return firstCharacter == lastCharacter;
            } else {
                return canChain(words, lastCharacter, pos + 1);
            }
        }
        
        return false;
    }

    private char getFirstCharacter(String[] words, int wordIdx) throws NotEnoughWords, NotEnoughCharacters {

        if (words.length < wordIdx) {
            throw new NotEnoughWords();
        }

        char[] arr = words[wordIdx].toCharArray();

        if (arr.length > 0) {
            return arr[0];
        }

        throw new NotEnoughCharacters();
    }

    private char getLastCharacter(String[] words, int wordIdx) throws NotEnoughWords, NotEnoughCharacters {

        if (words.length < wordIdx) {
            throw new NotEnoughWords();
        }

        char[] arr = words[wordIdx].toCharArray();

        if (arr.length > 0) {
            return arr[arr.length - 1];
        }

        throw new NotEnoughCharacters();
    }
}

class NotEnoughWords extends Exception {
    
}

class NotEnoughCharacters extends Exception {
    
}