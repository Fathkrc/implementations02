package com.algorithms;

import org.openjdk.jmh.annotations.*;

import java.util.LinkedList;

public class BenchmarkTests {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(new String[]{BenchmarkTests.class.getSimpleName()});
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    public void dynamicArray_addToHead(Data data) {
        Integer[] result = new Integer[100000];
        for (int i = 0 ; i < 9_999; i++){
            data.dynamicArray.add(0,result[i]);
        }
    }
    @Benchmark
    @Fork(value = 1, warmups = 0)
    public void singlyLingkedList_addToHead(Data data) {
        Integer[] result = new Integer[100_000];
        for (int i = 0 ; i < 9_999; i++){
            data.dynamicArray.add(0,result[i]);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    public void originalLinkedList_addToHead(Data data) {
        Integer[] result = new Integer[100_000];
        for (int i = 0 ; i < 9_999; i++){
            data.dynamicArray.add(0,result[i]);
        }
    }


    @State(Scope.Benchmark)
    public static class Data {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        LinkedList<Integer> linkedListOrg = new LinkedList<>();

    }
/*                      Results for 10_000 Integer values
BenchmarkTests.dynamicArray_addToHead        thrpt    5  0.732 ± 0.315  ops/s
BenchmarkTests.originalLinkedList_addToHead  thrpt    5  0.729 ± 0.312  ops/s
BenchmarkTests.singlyLingkedList_addToHead   thrpt    5  0.734 ± 0.318  ops/s

                                               Mode  Cnt  Score   Error  Units
BenchmarkTests.dynamicArray_addToHead        thrpt    5  0.736 ± 0.340  ops/s
BenchmarkTests.originalLinkedList_addToHead  thrpt    5  0.734 ± 0.312  ops/s
BenchmarkTests.singlyLingkedList_addToHead   thrpt    5  0.735 ± 0.304  ops/s
 */

}
