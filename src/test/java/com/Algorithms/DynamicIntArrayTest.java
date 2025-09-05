package test.java.com.Algorithms;

import com.algorithms.DynamicIntArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicIntArrayTest {
    private DynamicIntArray array;

    @BeforeEach
    void init() {
        array = new DynamicIntArray();
    }

    @Test
    void newCreatedArray_isSize0_isCapacity2() {
        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
        assertEquals(2, array.arrayCapacity());
    }


    @Test
    void isAddingValueIncreasingArraysSize() {
        for (int i = 0; i < 6; i++) {
            array.add(i);
            if (i == 2) assertEquals(4, array.arrayCapacity());
            if (i == 5) assertEquals(8, array.arrayCapacity());
        }
    }

    @Test
    void DoesAddToIndexAddingToExactIndex() {
        array.add(1);
        array.add(3);
        array.add(1, 2);
        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
    }

    @Test
    void DoesAddItem_outOfBounds_throwsIndexOutOfBoundException() {
        array.add(111);
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(-1, 333));
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(10, 666));
    }

    @Test
    void getItemOutOfBounds_ThrowsIndexOutOfBoundsException() {
        array.add(111);
        assertEquals(111, array.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(2));
    }

    @Test
    void RemoveExistingFirstItemThatGiven() {
        array.add(111);
        array.add(222);
        array.add(333);
        array.add(444);
        array.add(111);
        boolean removedOrNot = array.remove(111);
        assertTrue(removedOrNot); // removed first occurrence
        assertEquals(222, array.get(0));
        assertEquals(111, array.get(3)); // 222, 333, 444, 111
        assertEquals(4, array.size());// size must be decreased
    }
    @Test
    void removeAtRemovesAndReturnsCorrectValue() {
        DynamicIntArray a = new DynamicIntArray();
        a.add(111);
        a.add(222);
        a.add(333);   // [111,222,333]

        assertEquals(222, a.removeAt(1));
        assertEquals(2, a.size());
        assertEquals(111, a.get(0));
        assertEquals(333, a.get(1));
    }
    @Test
    void removeAt_outOfBoundsThrows() {
        DynamicIntArray a = new DynamicIntArray();
        a.add(666);

        assertThrows(IndexOutOfBoundsException.class, () -> a.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> a.removeAt(1));
    }
    @Test
    void iterator_iteratesInOrder_andThrowsAfterEnd() {
        for (int i = 0; i < 5; i++) array.add(i);

        Iterator<Integer> testIterator = array.iterator();
        for (int i = 0; i < 5; i++) {

            assertEquals(i, testIterator.next().intValue());
        }
        assertFalse(testIterator.hasNext());
        assertThrows(NoSuchElementException.class, testIterator::next);
    }
}
