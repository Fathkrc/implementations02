package com.algorithms;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 2, time = 5)
@Fork(value = 1)
public class BenchmarkTests {
    private static final int ITERATION_CNT = 10_000;
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[]{BenchmarkTests.class.getSimpleName()});
    }

    @Benchmark()
    public void dynamicArray_addToHead(Data data) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < ITERATION_CNT; i++)
            dynamicArray.add(0, data.val);
    }

    @Benchmark
    public void dynamicArray_addToTail(Data data) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            dynamicArray.add(data.val);
    }
    @Benchmark
    public void jdkDynamicArray_addToHead(Data data) {
        ArrayList<Integer> dynamicArray = new ArrayList<>();
        for (int i = 0; i < ITERATION_CNT; i++)
            dynamicArray.add(0, data.val);
    }
    @Benchmark
    public void jdkDynamicArray_addToTail(Data data) {
        ArrayList<Integer> dynamicArray = new ArrayList<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            dynamicArray.add(data.val);
    }
    @Benchmark
    public void linkedList_addToHead(Data data) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            linkedList.add(0, data.val);
    }
    @Benchmark
    public void linkedList_addToTail(Data data) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            linkedList.add(data.val);
    }
    @Benchmark
    public void jdkLingkedList_addToHead(Data data) {
        LinkedList<Integer> jdkLinkedList = new LinkedList<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            jdkLinkedList.add(0, data.val);
    }
    @Benchmark
    public void jdkLinkedList_addToTail(Data data) {
        LinkedList<Integer> jdkLinkedList = new LinkedList<>();
        for (int i = 0 ; i < ITERATION_CNT; i++)
            jdkLinkedList.add(data.val);
    }
/*
Benchmark                                  Mode  Cnt      Score   Error  Units
BenchmarkTests.dynamicArray_addToHead     thrpt    2    197.127          ops/s
BenchmarkTests.dynamicArray_addToTail     thrpt    2  32326.904          ops/s something is wrong
BenchmarkTests.jdkDynamicArray_addToHead  thrpt    2    197.337          ops/s
BenchmarkTests.jdkDynamicArray_addToTail  thrpt    2  31677.933          ops/s
BenchmarkTests.jdkLinkedList_addToHead    thrpt    2  34010.849          ops/s  ????
BenchmarkTests.jdkLinkedList_addToTail    thrpt    2  28547.519          ops/s 
BenchmarkTests.linkedList_addToHead       thrpt    2  73455.907          ops/s
BenchmarkTests.linkedList_addToTail       thrpt    2      8.735          ops/s
 */
    @State(Scope.Benchmark)
    public static class Data {
        Integer val = 10;
    }

}
