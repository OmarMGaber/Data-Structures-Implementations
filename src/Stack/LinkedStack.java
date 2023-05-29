package Stack;

import Nodes.Node;

public class LinkedStack<T> implements Stack {
    private Node top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public T pop() {
        T data = null;
        if (!isEmpty()) {
            data = (T) top.data;
            top = top.next;
        }
        return data;
    }

    @Override
    public T peek() {
        return (T) top.data;
    }

    @Override
    public void push(Object element) {
        Node<T> newNode = new Node<T>((T) element);
        if (element == null) {
            return;
        }
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = top;
        sb.append("[");
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(",");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}