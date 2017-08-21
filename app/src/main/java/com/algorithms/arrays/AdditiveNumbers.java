package com.algorithms.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dsaha on 8/20/17.
 */

public class AdditiveNumbers {

    /*
    public int[] getAdditiveNumbers (String string) {

        ArrayList<Integer> list = new ArrayList();

        int length = string.length();

        for (int i = 0; i <= length/2; i++) {

            if (string.charAt(0)=='0' && i > 0) {
                break;
            }

            String firstOperandString = string.substring(0,i+1);
            BigInteger firstOperand = new BigInteger(firstOperandString);

            int lengthOfElementsInFirstOperand = i;

            for (int j = j+1;  Math.max(lengthOfElementsInFirstOperand, j - (lengthOfElementsInFirstOperand+1)) < string.length() - 1 - j; j++) {

                if (string.charAt(i+1) == '0' && j > i+1) {
                    break;
                }

                String secondOperandString = string.substring(i+1,j+1);
                BigInteger secondOperand = new BigInteger(secondOperandString);

                if (isAdditive(firstOperand, secondOperand, string, j+1 )) {
                    return true;
                }
            }
        }

        return false;
    }
    */
    public boolean isAdditiveNumber (String string) {

        ArrayList<Integer> list = new ArrayList();

        int length = string.length();

        for (int i = 0; i <= length/2; i++) {

            if (string.charAt(0)=='0' && i > 0) {
                break;
            }

            String firstOperandString = string.substring(0,i+1);
            BigInteger firstOperand = new BigInteger(firstOperandString);

            int lengthOfElementsInFirstOperand = i;

            for (int j = i+1;  Math.max(lengthOfElementsInFirstOperand, j - (lengthOfElementsInFirstOperand+1)) < string.length() - 1 - j; j++) {

                if (string.charAt(i+1) == '0' && j > i+1) {
                    break;
                }

                String secondOperandString = string.substring(i+1,j+1);
                BigInteger secondOperand = new BigInteger(secondOperandString);

                if (isAdditive(firstOperand, secondOperand, string, j+1 )) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAdditive(BigInteger one, BigInteger two, String string, int start) {

        if (string.length() == start) {
            return true;
        }

        BigInteger answer = one.add(two);

        boolean isValid = string.startsWith(answer.toString(), start) && isAdditive(two, answer,string, start+answer.toString().length());
        return isValid;
    }

        /*
    private boolean isAdditive(BigInteger one, BigInteger two, String string, int index) {

        boolean isAdditive = false;

        if (!isValid(one) || !isValid(two)) {
            return false;
        }

        int num1 = Integer.parseInt(one);
        int num2 = Integer.parseInt(two);

        int candidateAnswer = Integer.parseInt(candidateAnswerString);
        int computedAnswer = num1+num2;

        String computedAnswerString = String.valueOf(computedAnswer);

        if (candidateAnswer == computedAnswer) {
            return true;
        }

        /*
        else if ((candidateAnswerString.length() < computedAnswerString.length()) ||
                    (computedAnswerString == candidateAnswerString.substring(0, computedAnswerString.length()))){
            // If the lenght of the computed string is greater than the candidate string then return false
            // If the length of the computed string is less than the candidate string the check if the computed string
            //    a prefix of the candidateString
            return false;
        } else {
            return isAdditive()
        return false;
    }
    */

}
