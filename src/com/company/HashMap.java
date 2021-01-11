package com.company;

import java.util.LinkedList;

public class HashMap {
    private static class Entry {
        private int key;
        private String value;

        public Entry(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        int index = hash(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }
        var bucket = entries[index];
        for (var entry : bucket) {
            if (key == entry.key) {
                entry.value = value;
                return;
            }
        }
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);
        if (entries[index] != null) {
            for (Entry entry : entries[index]) {
                if (key == entry.key) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        if (entries[index] == null)
            throw new IllegalStateException();
        for(var entry : entries[index]) {
            if (entry.key == key){
                entries[index].remove(entry);
                return;
            }
        }
        throw  new IllegalStateException();
    }
    private int hash(int key) {
        return (key % entries.length);
    }
}
