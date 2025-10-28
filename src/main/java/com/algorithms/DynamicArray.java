package com.algorithms;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
    private T[] baseArray;
    private int size;
    private int modificationCount = 0;

    public DynamicArray() { //Constructor creates an array with 2 items and size is default 0
        baseArray =(T[])new  Object[2];
        size = 0;
    }
    public void add(T value) {
        if (size == baseArray.length) doubleBaseArraySize();
        baseArray[size++] = value;
        modificationCount++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > baseArray.length) {
            throw new IndexOutOfBoundsException( index +"is an invalid index, " + "array size: " + size);
        }
        if (size == baseArray.length) doubleBaseArraySize();
        System.arraycopy(baseArray, index, baseArray, index + 1, size - index);
        baseArray[index] = value;
        modificationCount++;
        size++;
    }

    public boolean remove(T val) {
        int i = indexOf(val);
        if (i == -1) return false;
        removeAt(i); // Java arraylist does this way also ,
        return true;
    }
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index +"is an invalid index, " + "array size: " + size);
        T removedValue = baseArray[index];
        System.arraycopy(baseArray, index + 1, baseArray, index, size - index - 1);
        size--;
        modificationCount++;
        return removedValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index +"is an invalid index, " + "array size: " + size);
        return baseArray[index];
    }

    public int size() {
        return size;
    }

    int arrayCapacity() {
        return baseArray.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int prev = 0;
            int curr = -1;
            int expectedModCount = modificationCount;

            private void checkModificationCount(){
                if (modificationCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
            public boolean hasNext() {
                checkModificationCount();
                return prev < size;
            }
            public T next() {
                checkModificationCount();
                if (!hasNext()) throw new NoSuchElementException();
                curr = prev;
                return baseArray[prev++];
            }
            @Override
            public void remove() {
                checkModificationCount();
                if (curr < 0) throw new IllegalStateException("next() not called or already removed");
                // shift left to cover removed slot
                System.arraycopy(baseArray, curr + 1, baseArray, curr, size - curr - 1);
                baseArray[--size] = null; // prevent memory leak
                prev = curr;    // reset cursor
                curr = -1;
                modificationCount++;
                expectedModCount++;

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
        return -1;// Done!!

    }

}


