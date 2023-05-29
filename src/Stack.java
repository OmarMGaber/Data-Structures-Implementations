public class Stack<T> {
    int top;
    int size;
    T[] array;

    Stack(int size) {
        this.size = size;
        array = (T[]) new Object[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }


    public boolean push(T element) {
        if (!isFull()) {
            array[++top] = element;
            return true;
        }
        return false;
    }

    public T pop() {
        if (!isEmpty()) {
            return array[top--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return array[top];
        }
        return null;
    }

    public void printStack() {
        if (!isEmpty()) {
            Stack temp = new Stack<T>(size);

            while (!isEmpty()) {
                System.out.print(array[top]);
                temp.push(pop());
            }

            System.out.println();
            while (!temp.isEmpty()) {
                push((T) temp.pop());
            }
        }
    }

    private void pushReversed(T temp) {
        if (isEmpty()) {
            push(temp);
        } else {
            T temp2 = pop();
            pushReversed(temp);
            push(temp2);
        }
    }

    public void reverseStackRecursively() {
        if (!isEmpty()) {
            T temp = pop();
            reverseStackRecursively();
            pushReversed(temp);
        }
    }
}
