package main.java.com.Algorithms;

public class SinglyLinkedList<T> {

    private Node<T> head; // singly linked list no tail
    private int size;

    public SinglyLinkedList(){
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
    public void add(int index, int value){


    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index error");
        }
        Node<T> current = head;
        //iterating nodes to take value
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
