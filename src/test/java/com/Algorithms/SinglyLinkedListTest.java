package test.java.com.Algorithms;

import com.algorithms.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {


    @Test
    void addingItemAppendsSizeGrows() {
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
    void addToIndexAddsItemToExactIndex() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(555);
        test.add(2,333);
        test.add(3,444);
        assertEquals(333,test.get(2));
        assertEquals(444,test.get(3));
        assertEquals(555,test.get(4));
    }
    @Test
    void getOutOfBoundThrows(){
        SinglyLinkedList<Boolean> test = new SinglyLinkedList<>();
        test.add(0,true);
        assertThrows(IndexOutOfBoundsException.class,()-> test.get(2));

    }
    @Test
    void addingItemOutOfIndexThrowsIndexOutOfBoundException(){
        SinglyLinkedList<Double> test = new SinglyLinkedList<>();
        test.add(0.4);
        test.add(4.5);
        assertThrows(IndexOutOfBoundsException.class,()-> test.add(3,6.6));
        assertThrows(IndexOutOfBoundsException.class,()-> test.add(-1,1.2));

    }
    @Test
    public void removeAt_removesCorrectIndex_evenWithDuplicates() {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(111);
        test.add(222);
        test.add(222);
        test.add(333); // [111,222,222,333]
        Integer removed = test.removeAt(2); // remove the second '2'
        assertEquals(222, removed);
        assertEquals(3, test.size());
        assertEquals(111, test.get(0));
        assertEquals(222, test.get(1));  // first 2 still there
        assertEquals(333, test.get(2));
    }



}
