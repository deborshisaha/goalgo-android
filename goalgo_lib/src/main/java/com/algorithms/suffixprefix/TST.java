/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.suffixprefix;

import java.util.ArrayList;

public class TST {

    private class TSTNode {

        TSTNode left;
        TSTNode right;
        TSTNode middle;
        Character ch;
        boolean endOfWord;
        ArrayList<String> suggestions = new ArrayList<>();

        TSTNode() {
        }

        TSTNode(Character ch) {
            this.left = null;
            this.middle = null;
            this.right = null;
            this.ch = ch;
        }
    }

    private TSTNode head;

    public TST() {
        this.head = null;
    }

    // Get head
    public TSTNode getRoot() {
        return head;
    }

    // insert
    public boolean insert(String word, String suggestion) {

        if (word == null || word.length() == 0) {
            return false;
        }

        // check if any key present
        TSTNode n = this.getNodeToEndOfTheWord(word);

        if (n != null) {
            n.endOfWord = true;
            n.suggestions.add(suggestion);
            return true;
        }

        // convert it to array
        char[] array = word.toCharArray();

        TSTNode node = getRoot();
        //TSTNode nextNode = null;

        for (int i = 0; i < array.length;) {

            char characterToBeInserted = array[i];

            if (node == null) {

                // can happen only when the root is null
                node = new TSTNode(characterToBeInserted);
                head = node;
                i++;
                continue;
            }

            // Get the node
            if (characterToBeInserted < node.ch) {

                if (node.left == null) {

                    node.left = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go left
                node = node.left;

            } else if (characterToBeInserted == node.ch) {
                if (node.middle == null) {

                    node.middle = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go middle
                node = node.middle;

            } else if (characterToBeInserted > node.ch) {
                if (node.right == null) {

                    node.right = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go right
                node = node.right;
            }
        }

        node.endOfWord = true;
        System.out.println("inserting " + suggestion + " for word " + word);
        node.suggestions.add(suggestion);

        return true;
    }

    // search
    private TSTNode getNodeToEndOfTheWord(String searchString) {

        if (searchString == null || searchString.length() == 0) {
            return null;
        }

        // convert it to array
        char[] array = searchString.toCharArray();

        TSTNode node = getRoot();

        if (node == null) {
            return null;
        }

        int i = 0;

        if (node.ch != array[0]) {
            return null;
        }

        for (i = 1; i < array.length;) {

            char currentCharacter = array[i - 1];
            char nextCharacter = array[i];

            if (node == null) {
                break;
            }

            if (node.ch == currentCharacter) {
                i++;
            }
 
            TSTNode nextNode = getNextNode(node, nextCharacter);
            
            if (nextNode != null) {
                node = nextNode;
            } else {
                break;
            }
        }
        
        return node;
    }

    public boolean isPresent(String word) {
        TSTNode n = this.getNodeToEndOfTheWord(word);
        return (n != null);
    }

    public ArrayList<String> getSuggestions(String word) {
        TSTNode n = this.getNodeToEndOfTheWord(word);
        if (n == null) {
            return null;
        }
        return n.suggestions;
    }

    private TSTNode getNextNode(TSTNode node, char nextCharacter) {
        if (node.ch == nextCharacter) {
            return node.middle;
        } else if (node.ch < nextCharacter) {
            return node.right;
        } else if (node.ch > nextCharacter) {
            return node.left;
        }

        return null;
    }

    // delete
    public boolean delete(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        char[] arr = word.toCharArray();

        return deleteUtil(getRoot(), arr, 0);
    }

    public boolean deleteUtil(TSTNode node, char[] arr, int index) {

        if (node == null) {
            return true;
        }

        TSTNode nextNode = null;

        if (node.ch == arr[index]) {
            // move straight
            nextNode = node.middle;
        } else if (node.ch <= arr[index]) {
            nextNode = node.right;
        } else if (node.ch > arr[index]) {
            nextNode = node.left;
        }

        if (deleteUtil(nextNode, arr, index + 1)) {
            // If deleting the node below succeeded then delete this one
            if (node.right == null && node.middle == null && node.right == null) {
                return true;
            }
        }

        return false;
    }

    public static void driver() {
        TST tst = new TST();

        tst.insert("seat", "seating");
        tst.insert("seat", "seated");
        tst.insert("seed", "seeded");

        String targetString = "seed";
        ArrayList<String> suggestions = tst.getSuggestions(targetString);
        if (suggestions != null && !suggestions.isEmpty()) {
            suggestions.forEach((suggestion) -> {
                System.out.println(suggestion);
            });
        } else {
            System.out.println("No suggestions for '" + targetString + "'");
        }

    }
}
