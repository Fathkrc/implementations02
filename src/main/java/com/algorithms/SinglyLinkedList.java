package com.algorithms;

public class SinglyLinkedList<T> {

    private MyNode<T> head; // singly linked list no tail
    private int size;
// todo: null remove
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        MyNode<T> newNode = new MyNode<>(value);
        if (head == null) {
            head = newNode;// pointing new node

        } else {
            MyNode<T> current = head;
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
            MyNode<T> n = new MyNode<>(value);
            n.next = head;
            head = n;
        } else {
            MyNode<T> prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next; // Node at [index-1]
            MyNode<T> n = new MyNode<>(value);
            n.next = prev.next;  //  previous Node's pointer is now new Node's pointer
            prev.next = n;       // Node at index-1 is pointing the new Node
        }
        size++;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = head;
        //iterating Nodes to take value * index * time
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean remove(T value) {  // remove with the value
        //  (null or non-null)
        if ((value == null && head.data == null) ||
                (value != null && value.equals(head.data))) {
            head = head.next;
            size--;
            return true;
        }

        // Case 2: head goes to next element
        for (MyNode<T> prev = head, cur = head.next;
             cur != null;
             prev = cur, cur = cur.next) {

            if ((value == null && cur.data == null) ||
                    (value != null && value.equals(cur.data))) {
                prev.next = cur.next;
                size--;
                return true;
            }
        }
        return false; // value is not found
    }

    public T removeAt(int index) {  // remove with index
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode<T> nodeToRemove;
        if (index == 0) {
            nodeToRemove = head;
            head = head.next;
        } else {
            MyNode<T> prev = head;
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
