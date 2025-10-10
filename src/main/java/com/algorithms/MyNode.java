package com.algorithms;

public class MyNode<T> {

    T data;
    MyNode<T> next;

    // Generic data
    public MyNode(T data) {
        this.data = data;
        this.next=null;
    }

}
