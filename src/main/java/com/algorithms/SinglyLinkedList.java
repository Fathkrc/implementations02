package com.algorithms;

public class SinglyLinkedList<T> {

    private Node<T> head; // singly linked list no tail
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;// pointing new node

        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            //adding to end
        }
        size++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {  //if index is 0 the Node we are adding is becoming the new head
            Node<T> n = new Node<>(value);
            n.next = head;
            head = n;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next; // Node at [index-1]
            Node<T> n = new Node<>(value);
            n.next = prev.next;  //  previous Node's pointer is now new Node's pointer
            prev.next = n;       // Node at index-1 is pointing the new Node
        }
        size++;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        //iterating Nodes to take value * index * time
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean remove(T value) {  // remove with the value
        if (head == null || value == null) return false;

        if (value.equals(head.data)) {  //checking first
            head = head.next;
            size--;
            return true;
        }

        for (Node<T> prev = head, /* Node<T> */ cur = head.next;   // [data - prev] -> [data- current] -> ...
             cur != null;
             prev = cur, cur = cur.next) {

            if (cur.data.equals(value)) {
                prev.next = cur.next;
                size--;
                return true;
            }
        }
        return false; // value is not found
    }

    public T removeAt(int index) {  // remove with index
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> nodeToRemove;
        if (index == 0) {
            nodeToRemove = head;
            head = head.next;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            nodeToRemove = prev.next;
            prev.next = nodeToRemove.next;
        }
        size--;
        return nodeToRemove.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
