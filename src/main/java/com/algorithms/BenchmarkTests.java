package com.algorithms;

import org.openjdk.jmh.annotations.*;

public class BenchmarkTests {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[]{BenchmarkTests.class.getSimpleName()});
    }

    @Benchmark
    @Fork(value = 5, warmups = 0)
//    @Warmup(iterations = 5)
    public void dynamicArrayAdd(Data data) {
        data.dynamicArray.add(7);
    }

    @Benchmark @Fork(value = 1, warmups = 0)
//    @Warmup(iterations = 5)
    public void SinglyLinkedListAdd(Data data) {
        data.singlyLinkedListinkedList.add(7);
    }

//    @Benchmark @Fork(value = 1, warmups = 0)
//    @Warmup(iterations = 5)
//    public void linkedListAdd(Data data) {
//        data.linkedList.add(42);
//    }

    @State(Scope.Benchmark)
    public static class Data {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        SinglyLinkedList<Integer> singlyLinkedListinkedList = new SinglyLinkedList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
    }

}
