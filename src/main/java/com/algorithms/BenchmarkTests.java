package com.algorithms;

import org.openjdk.jmh.annotations.*;

public class BenchmarkTests {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[]{BenchmarkTests.class.getSimpleName()});
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
//    @Warmup(iterations = 5)
    public void dynamicArrayAdd(Data data) {
        data.dynamicArray.add(7);
    }
    // dynamic array doubles its size forever and it causes unbounded growth

    @Benchmark @Fork(value = 1, warmups = 0)// value is how many jvm I want to work with
//    @Warmup(iterations = 5)
    public void SinglyLinkedListAdd(Data data) {
        data.linkedList.add(7);
    }
//              SinglyLinkedListAdd":
//            1636.771 ±(99.9%) 773.023 ops/s [Average]
//            (min, avg, max) = (1429.765, 1636.771, 1909.007), stdev = 200.752
//    CI (99.9%): [863.748, 2409.793] (assumes normal distribution)add(42);


    @State(Scope.Benchmark)
    public static class Data {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
    }

}
