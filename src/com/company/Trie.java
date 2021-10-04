package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        private Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        private boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        private void removeChild(char ch) {
            children.remove(ch);
        }

        private Node getChild(char ch) {
            return children.get(ch);
        }

        private void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        private boolean hasChildren() {
            return !children.isEmpty();
        }

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", isEndOfWord=" + isEndOfWord + '}';
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var character : word.toCharArray()) {
            if (!current.hasChild(character)) {
                current.addChild(character);
            }
            current = current.getChild(character);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;
        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root.value);
        for (var child : root.getChildren()
        ) {
            traverse(child);
        }
    }


    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) {
            System.out.println("No word to remove");
            return;
        }
        remove(child, word, index + 1);
        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> autoComplete(String prefix){
        if (prefix==null)
            return null;
        List<String> words = new ArrayList<>();
        Node lastNode = getLastNode(prefix);
        findWords(prefix,lastNode,words);
        return words;
    }

    private void findWords(String prefix, Node lastNode, List<String> words){
        if(lastNode.isEndOfWord){
            words.add(prefix);
        }
        for (var child:lastNode.getChildren()
             ) {
            findWords(prefix+child.value,child, words);
        }
    }

    private Node getLastNode(String word){
        if (word == null)
            return null;
        var current = root;
        for (char ch:word.toCharArray()
             ) {
            var child = current.getChild(ch);
            current = child == null ? null : current.getChild(ch);
        }
        return current;
    }
}
