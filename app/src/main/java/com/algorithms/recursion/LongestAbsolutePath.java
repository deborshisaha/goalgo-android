package com.algorithms.recursion;

import java.util.Stack;

public class LongestAbsolutePath {

    public static void driver() {
        LongestAbsolutePath llp = new LongestAbsolutePath();
        System.out.println(llp.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public int lengthLongestPath(String string) {

        String[] tokens = string.split("\n");

        int maxLength = Integer.MIN_VALUE;

        int len = 0;

        Stack<Integer> levelStack = new Stack();

        Stack<String> dataStack = new Stack();

        // Loop
        for (String token : tokens) {

            int level = 1;

            int startIndex = 0;

            while (startIndex < token.length()) {
                if (token.charAt(startIndex) == '\t') {
                    level++;
                } else {
                    break;
                }
                startIndex++;
            }

            // Current level I am at
            int currentLevel = levelStack.isEmpty() ? 1 : levelStack.peek();

            //System.out.print("previous current level:" + currentLevel);
            //System.out.println(" level:" + level);
            // keep popping till the level > currentLevel becomes same
            while (!(currentLevel < level) && !levelStack.isEmpty()) {
                levelStack.pop();
                currentLevel = levelStack.peek();
                String data = dataStack.pop();

                len -= data.length();
                //System.out.println(">> data:" + data + " len:" + len + " cl:" + currentLevel);
            }

            // Once data was popped and we are at the right leve
            // Add the next file
            String data = token.substring(startIndex);
            //System.out.print("Current level:" + currentLevel);
            //System.out.println(" level:" + level + " data:" + data);

            if (!dataStack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append('\\').append(data);
                data = sb.toString();
            }

            len += data.length();
            levelStack.push(level);
            dataStack.push(data);
            //System.out.println(" len:" + len + " maxLength:" + maxLength + " data:" + data + " datalength:" + data.length());
            maxLength = Integer.max(len, maxLength);
        }

        return maxLength;
    }
}
