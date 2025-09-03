package com.algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicIntArray implements Iterable<Integer> {
    private int[] baseArray;
    private int size;

    public DynamicIntArray() { //Constructor creates an array with 2 items and size is default 0
        baseArray = new int[2];
        size = 0;
    }

    public void add(int value) {
        if (size == baseArray.length) doubleBaseArraySize();
        baseArray[size++] = value;
    }

    public void add(int index, int value) {
        if (index < 0 || index > baseArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (size == baseArray.length) doubleBaseArraySize();
        System.arraycopy(baseArray, index, baseArray, index + 1, size - index);
        baseArray[index] = value;
        size++;
    }

    public boolean remove(int val) {
        int i = indexOf(val);
        if (i == -1) return false;
        System.arraycopy(baseArray, i + 1, baseArray, i, size - i - 1);
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return baseArray[index];
    }

    public int size() {
        return size;
    }

    public int arrayCapacity() {
        return baseArray.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0;
            public boolean hasNext() {
                return i < size;
            }
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return baseArray[i++];
            }
            // need to check documents
        };
    }

    // Utils
    private void doubleBaseArraySize(){
        int[] newArr = new int[baseArray.length * 2];
        System.arraycopy(baseArray, 0, newArr, 0, size);
        baseArray = newArr;
    }

    int indexOf(int val){
        for (int i=0;i< baseArray.length ;i++ ) {
            if (baseArray[i] == val) return i;
        }
        return -1;
    }

}


