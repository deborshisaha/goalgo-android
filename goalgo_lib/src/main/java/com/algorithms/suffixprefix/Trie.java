package com.algorithms.suffixprefix;

import java.util.HashMap;

public class Trie {

    public boolean search(String target) {
        
        char[] arr = target.toCharArray();
        
        int i = 0;

        TrieNode n = root;
        
        while(i != arr.length) {
            
            char ch = arr[i];
            
            TrieNode node = n.children.get(ch);
            
            if (node == null) {
                return false;
            } 
            
            n = node;
            
            i++;
        }
        
        // when end of zero the node should be endOfWord
        return (n!=null && n.endWord);
    }

    private class TrieNode {

        boolean endWord;
        HashMap<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
            this.endWord = false;
        }
    }

    private final TrieNode root = new TrieNode();

    // insert
    public boolean insert(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        char[] charArr = word.toCharArray();

        TrieNode currentNode = root;

        for (int i = 0; i < charArr.length; i++) {

            // Get the character
            Character ch = charArr[i];

            // Look up the hash map to check if a node is present.
            TrieNode node = currentNode.children.get(ch);

            // Node is present for that character
            if (node != null) {
                currentNode = node;
            } else {
                // no node is present for the character
                // create a new node
                node = new TrieNode();

                // save it in the map at this node
                currentNode.children.put(ch, node);

                currentNode = node;
            }

        }

        currentNode.endWord = true;

        return true;

    }

    // search
    public boolean isPresent(String searchString) {

        if (searchString == null || searchString.length() == 0) {
            return false;
        }

        char[] charArr = searchString.toCharArray();

        TrieNode currentNode = root;

        for (int i = 0; i < charArr.length; i++) {

            // Get the character
            Character ch = charArr[i];

            // Look up the hash map to check if a node is present.
            TrieNode node = currentNode.children.get(ch);

            // Node is present for that character
            if (node == null) {
                return false;
            }

            currentNode = node;
        }

        return currentNode.endWord;
    }

    // delete
    public void delete(String word) {
        deleteUtil(root, word.toCharArray(), 0);
    }

    private boolean deleteUtil (TrieNode node , char[] word, int position) {
        
        if (node == null) {
            return true;
        }
        
        if (position == (word.length-1) && node.endWord) {
            // any other node from here?
            if (!node.children.isEmpty()) {
                node.endWord = false;
                return false;
            }
            
            return true;
        }
        
        TrieNode childNode = node.children.get(word[position]);
        if (deleteUtil(childNode, word,position+1)) {
            node.children.put(word[position], null);
            return true;
        }
        
        return false;
    }
    
    public static void driver() {
        Trie trie = new Trie();

        trie.insert("seat");
        trie.insert("seede");

        String targetString = "seed";
        System.out.println(trie.search(targetString));

    }

}
