package org.example;

class HashTableLinear {

    private Integer[] table;
    private int size;

    public HashTableLinear(int size) {
        this.size = size;
        table = new Integer[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {

        int index = hash(key);

        int i = 0;

        while (table[(index + i) % size] != null) {
            i++;
        }

        table[(index + i) % size] = key;
    }

    public boolean search(int key) {

        int index = hash(key);

        int i = 0;

        while (table[(index + i) % size] != null) {

            if (table[(index + i) % size] == key) {
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