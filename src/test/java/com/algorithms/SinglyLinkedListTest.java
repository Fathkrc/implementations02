package com.algorithms;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {


    @Test
    public void addingItem_appendsSizeGrows() {
        SinglyLinkedList<String> test = new SinglyLinkedList<>();
        assertTrue(test.isEmpty());
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals(3, test.size());

        assertEquals("A", test.get(0));
        assertEquals("C", test.get(2));
        assertFalse(test.isEmpty());
    }

    @Test
    void addToIndex_addsItemToExactIndex() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(555);
        test.add(2, 333);
        test.add(3, 444);
        assertEquals((Integer)333, test.get(2));
        assertEquals((Integer)444, test.get(3));
        assertEquals((Integer)555, test.get(4));
    }

    @Test
    void getOutOfBound_throwsIndexOutOfBoundsException() {
        SinglyLinkedList<Boolean> test = new SinglyLinkedList<>();
        test.add(0, true);
        assertThrows(IndexOutOfBoundsException.class, () -> test.get(2));

    }

    @Test
    void addOutOfBounds_throwsIndexOutOfBoundsException() {
        SinglyLinkedList<Double> test = new SinglyLinkedList<>();
        test.add(0.4);
        test.add(4.5);
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(3, 6.6));
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(-1, 1.2));

    }

    @Test
    void removeAt_removesCorrectIndex_evenWithDuplicates() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(222);
        test.add(333); // [111,222,222,333]
        Integer removed = test.removeAt(2); // remove the second '2'
        assertEquals((Integer)222, removed);
        assertEquals(3, test.size());
        assertEquals((Integer)111, test.get(0));
        assertEquals((Integer)222, test.get(1));  // first 2 is still there
        assertEquals((Integer)333, test.get(2));
    }

    @Test
    void removeAtOutOfBounds_throwsIndexOutOfBoundsException() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(222);
        assertDoesNotThrow(() -> test.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(123, 4));
    }

    @Test
    void removeFirstValueAndLastValue_removesExactItem() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(333);
        test.add(444);
        assertTrue(test.remove(111));
        assertEquals(3, test.size()); // [222,333,444]
        assertEquals((Integer)222, test.get(0));
        assertTrue(test.remove(444));
        assertEquals(2, test.size()); // [222,333]
    }

    @Test
    void removeValue_nullBehavior() {
        SinglyLinkedList<String> test = new SinglyLinkedList<>();
        test.add(null);
        test.add("A"); // [null,"A"]
        assertNull(test.get(0));
        assertTrue(test.remove(null));  //  with value we can not remove null
        assertEquals(1, test.size());
        assertEquals("A", test.get(0));
    }

    @Test
    void removeAt_onlyElementMakesListEmpty() {
        SinglyLinkedList<String> test = new SinglyLinkedList<>();
        test.add("X");
        assertEquals("X", test.removeAt(0));
        assertTrue(test.isEmpty());
    }

    @Test
    void removeNotExistingValue_returnsFalse() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(1);
        test.add(2);
        assertFalse(test.remove(99));
        assertEquals(2, test.size());
    }

}

