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
            int cursor = 0;
//            int curr = -1;
            /*
            [ A, B, C, D ]
              0  1  2  3
            index = 0    next thing to return
            curr = -1  no element yet

             */
            int expectedModCount = modificationCount;

            private void checkModificationCount(){
                if (modificationCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
            private int nextIndex() { return Math.abs(cursor); } // -1 1 , -2 2
            private boolean canRemove() { return cursor < 0; }// flag can remove or not
            private void set(int nextIndex, boolean canRemove)
            { cursor = canRemove ? -nextIndex : nextIndex; }

            public boolean hasNext() {
                checkModificationCount();
                return nextIndex() < size;
            }
            public T next() {
            /*
                return A  (index=0)
                lastReturned = 0
                index = 1
            */
                checkModificationCount();
                if (!hasNext()) throw new NoSuchElementException();

                int i = nextIndex();     // i = index to give
                T val = baseArray[i];    // get element
                set(i + 1, true);        // move pointer, allow remove
                return val;
            }
            @Override
            public void remove() {
                checkModificationCount();
                if (!canRemove()) throw new IllegalStateException();
/*
remove item at curr=0 → remove A
shift left → [B, C, D]
size = 3
index = lastReturned = 0
lastReturned = -1  cannot remove again needs next

 */
                int last = nextIndex() - 1; // the guy we just returned!

                System.arraycopy(baseArray, last + 1, baseArray, last, size - last - 1);
                baseArray[--size] = null;

                set(last, false);   // pointer goes back, remove forbidden
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


