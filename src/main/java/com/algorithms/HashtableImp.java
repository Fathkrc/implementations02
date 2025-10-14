package com.algorithms;


import java.util.Objects;

public class HashtableImp <K,V>{
    private static final int DEFAULT_CAP = 16; // 2^4   last 4 bits
    private static final float LOAD_FACTOR = 0.75f;

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

    public V put(K key, V value) {
        int h = (key == null) ? 0 : key.hashCode();
        h ^= (h >>> 16);
        int i = h & (buckets.length - 1); // h & 0111

        // update if key exists
        for (Node<K,V> n = buckets[i]; n != null; n = n.next) {
            if (Objects.equals(n.key, key)) {
                V old = n.value;
                n.value = value;
                return old;
            }
        }

        // insert at bucket head
        buckets[i] = new Node<>(key, value, buckets[i]);
        size++;

        // resize if load factor exceeded
        if (size > buckets.length * LOAD_FACTOR) {
            resize(); // tiny, self-contained
        }
        return null;
    }

    public V remove(K key) {
        int h = (key == null) ? 0 : key.hashCode();
        h ^= (h >>> 16);
        int i = h & (buckets.length - 1);

        Node<K,V> prev = null, cur = buckets[i];
        while (cur != null) {
            if (Objects.equals(cur.key, key)) {
                if (prev == null) buckets[i] = cur.next; else prev.next = cur.next;
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    private void resize() {
        Node<K,V>[] old = buckets;
        Node<K,V>[] newBuckets = (Node<K,V>[]) new Node[old.length << 1]; // double (still power of two)
        // 1000 => 0001 0000
        // rehash all nodes into newBuckets (insert-at-head)
        for (Node<K,V> head : old) {
            for (Node<K,V> n = head; n != null; ) {
                Node<K,V> next = n.next;

                int h = (n.key == null) ? 0 : n.key.hashCode();
                h ^= (h >>> 16);
                int i = h & (newBuckets.length - 1);

                n.next = newBuckets[i];
                newBuckets[i] = n;
                n = next;
            }
        }
        buckets = newBuckets;
    }



    private static final class Node<K,V> {
        final K key;
        V value;
        Node<K,V> next;
        Node(K k, V v, Node<K,V> nx) { key = k; value = v; next = nx; }
    }



}
