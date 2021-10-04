package com.company;

import java.util.ArrayList;

public class BTree {
    private class Node {
        private Node leftChild;
        private Node rightChild;
        private final int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    public Node root;

    private boolean treeIsEmpty() {
        return root == null;
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private boolean isLeafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    private int Tmin(Node root) {
        if (treeIsEmpty()) {
            return -1;
        }
        if (isLeafNode(root))
            return root.value;
        return Math.min(root.value, Math.min(Tmin(root.leftChild), Tmin(root.rightChild)));
    }

    private int BSTmin(Node root) {
        if (isLeafNode(root)) {
            return root.value;
        }
        return BSTmin(root.leftChild);
    }

    private boolean equals(Node root, Node otherRoot) {
        if (root == null && otherRoot == null) {
            return true;
        }
        if (root != null && otherRoot != null) {
            return root.value == otherRoot.value &&
                    equals(root.leftChild, otherRoot.leftChild) &&
                    equals(root.rightChild, otherRoot.rightChild);
        }
        return false;
    }

    private void nodeAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        } else if (distance == 0) {
            list.add(root.value);
            return;
        } else if(distance < 0)
            return;
        nodeAtDistance(root.leftChild, distance - 1, list);
        nodeAtDistance(root.rightChild, distance - 1, list);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return isBST(root.leftChild, min, root.value - 1) &&
                isBST(root.rightChild, root.value + 1, max);
    }

    public void insert(int value) {
        var entry = new Node(value);
        if (treeIsEmpty()) {
            root = entry;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = entry;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = entry;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean contains(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value) {
                current = current.rightChild;
            } else if (value < current.value) {
                current = current.leftChild;
            } else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public int Tmin() {
        return Tmin(root);
    }

    public int BSTmin() {
        return BSTmin(root);
    }

    public boolean equals(BTree other) {
        return equals(root, other.root);
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void nodeAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        nodeAtDistance(root, distance, list);
        System.out.println(list);
    }

    public int height(Node root){
        if (root==null || isLeafNode(root)){
            return 0;
        }
        return 1+Math.max(height(root.rightChild),height(root.leftChild));
    }
    private void traverseLevelOrder(Node root){
        for(int i = 0; i <= height(root);i++){
            nodeAtDistance(i);
        }
    }
    public void traverseLevelOrder(){
        traverseLevelOrder(root);
    }
}
