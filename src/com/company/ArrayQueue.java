package com.company;

import java.util.Arrays;

public class ArrayQueue {

    int[] queue;

    ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    private int front;
    private int rear;
    private int count;

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int item) {
        if (count == queue.length)
            throw new IllegalStateException();
        queue[rear] = item;
        rear = (rear+1)% queue.length;
        count++;
    }
    
    public int remove() {
        int item = queue[front];
        queue[front] = 0;
        front = (front+1)% queue.length;
        count--;
        return item;
    }

    public int peek() {
        return queue[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
