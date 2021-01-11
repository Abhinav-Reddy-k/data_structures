package com.company;

public class LinkedList {
    private static class Node {
        public Node(int value) {
            this.value = value;
        }

        private final int value;
        private Node next;
    }

    private Node head;
    private Node tail;

    private boolean isEmpty() {
        return head == null;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else
            node.next = head;
        head = node;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node second = head.next;
        head.next = null;
        head = second;
    }

}
