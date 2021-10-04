package com.company;

public class AVLTree {
    private class AVLnode {
        private int height=0;
        private AVLnode leftChild;
        private AVLnode rightChild;
        private final int value;

        public AVLnode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private AVLnode root;

    public void insert(int value){
        root = insert(root,value);
    }

    private AVLnode insert(AVLnode root,int value){
        if(root==null){
            return new AVLnode(value);
        }
        else if(value < root.value){
            root.leftChild = insert(root.leftChild, value);
        }
        else if(value > root.value){
            root.rightChild = insert(root.rightChild,value);
        }
        root.height = 1 + Math.max(height(root.leftChild),height(root.rightChild));
        balance(root);
        return root;
    }

    private void balance(AVLnode root) {
        if(isLeftHeavy(root)){
//            System.out.println(root.value + "is left heavy");
        }
        else if(isRightHeavy(root)){
//            System.out.println(root.value + "is right heavy");
        }
    }

    public int height(AVLnode node){
        return node == null ? -1 : node.height;
    }

    private int balanceFactor(AVLnode node){
        return height(node.leftChild) - height(node.rightChild);
    }
    private boolean isLeftHeavy(AVLnode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLnode node){
        return balanceFactor(node) < -1;
    }
}
