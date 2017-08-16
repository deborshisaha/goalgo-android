package com.algorithms.recursion;

import java.util.Stack;

public class BracketChecker {
    
    public boolean check (String string) {
        
        Stack<Character> stack = new Stack<Character>();
        char[] expression = string.toCharArray();
        
        for (int i=0; i < expression.length; i++) {

            char ch = expression[i];

            if (i == 0) {
                // Push character into the stack
                // Continue with next character
                stack.push(ch);
                continue;
            }
            
            if (ch == '{'|| ch == '['||ch == '(') {
                stack.push(ch);
            } else if (ch == '}'|| ch == ']'||ch == ')') {
                // Check if this character is one of the closing brackets that was previously inserted
                char openingCharacter = getOpeningBracket(ch);
                char lastCharacter = stack.peek();
                
                if (lastCharacter == openingCharacter) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
    private char getOpeningBracket(char ch) {
        switch (ch) {
            case '}':return '{';
            case ']':return '[';
            case ')':return '(';
            default: return 0;
        }
    }
    
    public static void driver() {
        BracketChecker bracketChecker = new BracketChecker();
        String testString = "{[]()]}";
        System.out.println(testString+" is "+ bracketChecker.check(testString));
    }
}
