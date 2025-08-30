//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DynamicArray test1 = new DynamicArray();
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
        System.out.println("Dynamic array has " + test1.size() + " items");
        System.out.println("Capacity of Dynamic Array is " + test1.arrayCapacity());
        System.out.println("Is Array Empty ? : "+ test1.isEmpty());
        System.out.println("================================================");

    }
}
