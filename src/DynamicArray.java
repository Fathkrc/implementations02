public class DynamicArray {
    private int[] baseArray;
    private int size;

    public DynamicArray() { //Constructor creates an array with 2 items and size is default 0
        baseArray = new int[2];
        size = 0;
    }

    public void add(int value) {
        if (size == baseArray.length) {
            int[] newArray = new int[baseArray.length * 2];
            System.arraycopy(baseArray, 0, newArray, 0, size);
            baseArray = newArray;
        }
        baseArray[size++] = value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return baseArray[index];
    }

    public int size() {
        return size;
    }
    public int arrayCapacity(){
        return baseArray.length;
    }


}


