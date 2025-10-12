package com.algorithms;


import java.util.Objects;

public class HashtableImp <K,V>{
    private static final int DEFAULT_CAP = 16; // 2^4   last 4 bits
//    private static final float LOAD_FACTOR = 0.75f;

    private Node<K,V>[] buckets;
    private int size;

    public HashtableImp() {
        buckets = (Node<K,V>[]) new Node[DEFAULT_CAP];
    }
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    int capacity() { return buckets.length; } // package private for tests

    public V get(K key) {
        int h = (key == null) ? 0 : key.hashCode();
        /*
         h=                  10110010 00001011 00000000 00000100
         h >>> 16:           00000000 00000000 10110010 00001011
         h ^= (h >>> 16) =   10110010 00001011 10110010 00001111
         */
        h ^= (h >>> 16);
        int i = h & (buckets.length - 1);

        for (Node<K,V> n = buckets[i]; n != null; n = n.next) {
            if (Objects.equals(n.key, key)) return n.value;
        }
        return null;
    }


    private static final class Node<K,V> {
        final K key;
        V value;
        Node<K,V> next;
        Node(K k, V v, Node<K,V> nx) { key = k; value = v; next = nx; }
    }



}
