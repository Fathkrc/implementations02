package com.algorithms;

public class SpeedComparison {


    public static void main(String[] args) {
        System.out.println("===== APPEND =====");
        compareAppendItems(100000);
//         DynamicIntArray add 100000 items: 1 ms
//        SinglyLinkedList add 100000 items: 5483 ms

        System.out.println("\n===== GET (sequential) =====");
        compareGetItems(100000);
//        DynamicIntArray add 100000 items: 1 ms
//        SinglyLinkedList add 100000 items: 5481 ms

        System.out.println("\n===== REMOVE AT HEAD =====");
        compareRemoveAtHead(100000);
//        DynamicIntArray removeAt(0) worked 100000: times and the result is : 235 ms
//        SinglyLinkedList remove(0) worked 100000: times and the result is : 1 ms

    }

    public static void compareAppendItems(int loopCount) {
        // DYNAMIC ARRAY vs SINGLY LINKED APPEND

        // DYNAMIC ARRAY
        DynamicIntArray array = new DynamicIntArray();
        long startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) array.add(i);
        long endTime = System.nanoTime();
        System.out.println("DynamicIntArray add " + loopCount + " items: " + (endTime - startTime) / 1_000_000 + " ms");

        // SINGLY LINKED LIST
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) list.add(i);
        endTime = System.nanoTime();
        System.out.println("SinglyLinkedList add " + loopCount + " items: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareGetItems(int loopCount) {
        DynamicIntArray array = new DynamicIntArray();
        for (int i = 0; i < loopCount; i++) array.add(i);

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < loopCount; i++) list.add(i);

        long startTime, endTime;

        // array get
        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) array.get(i);
        endTime = System.nanoTime();
        System.out.println("DynamicIntArray get " + loopCount + " items: " + (endTime - startTime) / 1_000_000 + " ms");

        // list get
        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) list.get(i);
        endTime = System.nanoTime();
        System.out.println("SinglyLinkedList get " + loopCount + " items: " + (endTime - startTime) / 1_000_000 + " ms");

    }

    public static void compareRemoveAtHead(int loopCount) {

        // Dynamic array
        DynamicIntArray array = new DynamicIntArray();
        for (int i = 0; i < loopCount; i++) array.add(i);
        long startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) array.removeAt(0);
        long endTime = System.nanoTime();
        System.out.println("DynamicIntArray removeAt(0) worked " + loopCount + ": times and the result is : " + (endTime - startTime) / 1_000_000 + " ms");

        // Singly linked list
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < loopCount; i++) list.add(i);
        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) list.removeAt(0);
        endTime = System.nanoTime();
        System.out.println("SinglyLinkedList remove(0) worked " + loopCount + ": times and the result is : " + (endTime - startTime) / 1_000_000 + " ms");


    }

}
