package Stack;

public class ArrayBasedStack<T> implements Stack<T> {

    private int top;
    private T[] array;
    private int size;
    private int capacity;

    public ArrayBasedStack(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.top = -1;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            size--;
            return array[top--];
        }
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return array[top];
        }
        return null;
    }

    @Override
    public void push(T element) {
        if (!isFull()) {
            size++;
            array[++top] = element;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < top + 1; i++) {
            sb.append(array[i]);
            if (i != top) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
