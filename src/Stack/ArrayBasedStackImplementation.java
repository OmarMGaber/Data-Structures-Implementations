package Stack;

public class ArrayBasedStackImplementation implements Stack {
    private int top;
    private int size;
    private int[] array;

    ArrayBasedStackImplementation(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }

    @Override
    public int pop() {


        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean push(int element) {
        if (!isFull()) {
            array[++top] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public int size() {
        return size;
    }
}