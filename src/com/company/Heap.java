package com.company;

public class Heap {
    public Heap(int size) {
        this.heap = new int[size];
    }

    private final int[] heap;
    private int size;

    public void insert(int val) {
        if (isFull())
            throw new IllegalStateException();
        heap[size++] = val;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = heap[0];
        heap[0] = heap[--size];
        bubbleDown();
        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size > heap.length;
    }

    private void bubbleDown() {
        var index = 0;
        while (!isValidParent(index) && index <= size) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void bubbleUp() {
        var index = size - 1;
        while (heap[index] > heap[parentOf(index)] && index > 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        var isValid = heap[index] >= leftChild(index);
        if (hasRightChild(index)) {
            isValid &= heap[index] >= rightChild(index);
        }
        return isValid;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
}
