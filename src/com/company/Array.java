package com.company;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count ; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int num) {
        if (items.length == count) {

            int[] bigArray = new int[count*2];

            System.arraycopy(items, 0, bigArray, 0, count);
            items = bigArray;
        }
        items[count++] = num;
    }

    public void removeAt(int index){
        if (index >= count || index < 0) {
            System.out.println("Not Possible");
            throw new IllegalArgumentException();
        }
        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count ; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }
}
