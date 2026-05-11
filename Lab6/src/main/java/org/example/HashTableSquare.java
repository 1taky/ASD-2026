package org.example;

class HashTableSquare {

    private Integer[] table;
    private int size;

    public HashTableSquare(int size) {
        this.size = size;
        table = new Integer[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {

        int index = hash(key);

        int i = 0;

        while (table[(index + i * i) % size] != null) {
            i++;
        }

        table[(index + i * i) % size] = key;
    }

    public boolean search(int key) {

        int index = hash(key);

        int i = 0;

        while (table[(index + i * i) % size] != null) {

            if (table[(index + i * i) % size] == key) {
                return true;
            }

            i++;

            if (i == size) {
                return false;
            }
        }

        return false;
    }
}