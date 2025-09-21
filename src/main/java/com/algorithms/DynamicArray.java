package com.algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
    private T[] baseArray;
    private int size;

    public DynamicArray() { //Constructor creates an array with 2 items and size is default 0
        baseArray =(T[])new  Object[2];
        size = 0;
    }

    public void add(T value) {
        if (size == baseArray.length) doubleBaseArraySize();
        baseArray[size++] = value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > baseArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (size == baseArray.length) doubleBaseArraySize();
        System.arraycopy(baseArray, index, baseArray, index + 1, size - index);
        baseArray[index] = value;
        size++;
    }

    public boolean remove(T val) {
        int i = indexOf(val);
        if (i == -1) return false;
        System.arraycopy(baseArray, i + 1, baseArray, i, size - i - 1);
        size--;
        return true;
    }
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T removedValue = baseArray[index];
        System.arraycopy(baseArray, index + 1, baseArray, index, size - index - 1);
        size--;
        return removedValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return baseArray[index];
    }

    public int size() {
        return size;
    }

    protected int arrayCapacity() {
        return baseArray.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int cursor = 0;
            int last= -1;
            public boolean hasNext() {
                return cursor < size;
            }
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                last = cursor;
                return baseArray[cursor++];
            }
            @Override
            public void remove() {
                if (last < 0) throw new IllegalStateException("next() not called or already removed");
                // shift left to cover removed slot
                System.arraycopy(baseArray, last + 1, baseArray, last, size - last - 1);
                baseArray[--size] = null; // prevent memory leak
                cursor = last;    // reset cursor
                last = -1;
            }
        };
    }


    // Utils
    private void doubleBaseArraySize(){
        T[] newArr = (T[])new Object[baseArray.length * 2];
        System.arraycopy(baseArray, 0, newArr, 0, size);
        baseArray = newArr;
    }

    int indexOf(T val){
        for (int i=0;i< baseArray.length ;i++ ) {
            if (baseArray[i] == val) return i;
        }
        return -1;// coverage signed here ??
    }

}


