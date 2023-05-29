package Stack;

public interface Stack<T> {

    public T pop();

    public T peek();

    public void push(T element);

    public boolean isEmpty();

    public int size();

    public String toString();
}