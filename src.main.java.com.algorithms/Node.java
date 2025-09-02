public class Node<T> {

    T data;
    Node<T> next;

    // Generic data
    public Node(T data) {
        this.data = data;
        this.next=null;
    }

}
