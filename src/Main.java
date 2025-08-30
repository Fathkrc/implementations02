//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DynamicIntArray test1 = new DynamicIntArray();
        test1.add(12);
        test1.add(25);
        test1.add(45);
        test1.add(66);
        test1.add(100);
        test1.add(200);
        test1.add(200);
        test1.add(200);
        test1.add(200);
        for (int i = 0; i < test1.size(); i++) {
            System.out.println(test1.get(i));
        }
        System.out.println("Dynamic Int array has " + test1.size() + " items");
        System.out.println("Capacity of Dynamic Int Array is " + test1.arrayCapacity());
        System.out.println("Is Array Empty ? : "+ test1.isEmpty());
        System.out.println("================================================");

        SinglyLinkedList<String> testList1 = new SinglyLinkedList<>();
        testList1.add("A");
        testList1.add("B");
        testList1.add("C");

        System.out.println(testList1.get(0));
        System.out.println(testList1.get(2));
        System.out.println(testList1.size());
        System.out.println("Is Linked List Empty? :"+testList1.isEmpty()); // false
        System.out.println("================================================");
//        SinglyLinkedList<int> testList2 = new SinglyLinkedList<>();
//        not working with primitive data types I have to use Wrapper class
        SinglyLinkedList<Integer> testList2 = new SinglyLinkedList<>();
        testList2.add(111);
        testList2.add(222);
        testList2.add(333);
        System.out.println(testList2.get(0));
        System.out.println(testList2.get(1));
        System.out.println();
        System.out.println(testList2.size());
    }
}
