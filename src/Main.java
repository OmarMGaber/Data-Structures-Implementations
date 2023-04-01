import Queue.ArrayBasedQueue;
import Stack.ArrayBasedStack;
import Stack.LinkedStack;

public class Main {
    public static void main(String[] args) {
/*
        LinkedStack stack = new LinkedStack();

        stack.push(100);
        stack.push(43);
        stack.push(2);
        stack.push(13);
*/
        ArrayBasedQueue queue = new ArrayBasedQueue(10);

        queue.inQueue(5);
        queue.inQueue(3);
        queue.inQueue(23);
        queue.inQueue(532);
        queue.inQueue(12);

        queue.display();
        queue.display();
    }
}