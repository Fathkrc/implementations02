package com.algorithms;




import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class DynamicArrayTest {


    @Test
    void newCreatedArray_isSize0_isCapacity2() {
        DynamicArray<Integer> array= new DynamicArray<>();
        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
        assertEquals(2, array.arrayCapacity());
    }


    @Test
    void addingValue_increasesArraysSize() {
        DynamicArray<Double> array= new DynamicArray<>();
        array.add(12.0);
        array.add(13.0);
        assertEquals(2, array.arrayCapacity());
        array.add(14.0);
        assertEquals(4, array.arrayCapacity());


    }

    @Test
    void addToIndex_addingToExactIndex() {
        DynamicArray<Integer> array= new DynamicArray<>();
        array.add(1);
        array.add(3);
        array.add(1, 2);
        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
    }

    @Test
    void addItem_outOfBounds_throwsIndexOutOfBoundException() {
        DynamicArray<Character> array= new DynamicArray<>();
        array.add('T');
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(-1, 'A'));
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(10, 'B'));
    }

    @Test
    void getItemOutOfBounds_ThrowsIndexOutOfBoundsException() {
        DynamicArray<Boolean> array= new DynamicArray<>();
        array.add(true);
        assertTrue( array.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(2));
    }

    @Test
    void removeExistingFirstItem_OnDuplicates_removesFirst() {
        DynamicArray<Integer> array= new DynamicArray<>();
        array.add(111);
        array.add(111);
        assertTrue(array.remove(111)); // removed first occurrence
        assertEquals(111, array.get(0));
    }
    @Test
    void removeAt_removes_returnsCorrectValue() {
        DynamicArray<Integer> a = new DynamicArray<>();
        a.add(111);
        a.add(222);
        assertEquals(222, a.removeAt(1));
        assertEquals(1, a.size());
    }
    @Test
    void removeAt_outOfBoundsThrows() {
        DynamicArray<String> a = new DynamicArray<>();
        a.add("str");
        assertThrows(IndexOutOfBoundsException.class, () -> a.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> a.removeAt(1));
    }
    @Test
    void testIterator_iteratesInOrder_andThrowsAfterEnd() {
        DynamicArray<Integer> array= new DynamicArray<>();
        array.add(1);
        Iterator<Integer> testIterator = array.iterator();
        assertEquals(1, testIterator.next().intValue());
        assertFalse(testIterator.hasNext());
    }
    @Test
    void testIterator_remove() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(1); arr.add(2);
        Iterator<Integer> it = arr.iterator();
        it.next();
        it.remove();
        assertEquals(1, arr.size());
    }

    @Test
    void testIteratorRemove() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(1);
        arr.add(2);
        Iterator<Integer> it = arr.iterator();
        it.next();     // points to 1
        it.remove();
        assertEquals(1, arr.size());
        assertEquals(2, arr.get(0));
    }
}
