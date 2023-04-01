import Queue.ArrayBasedQueue;
import Queue.LinkedQueue;
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
        LinkedQueue queue = new LinkedQueue();

        queue.enQueue(5);
        queue.enQueue(3123123);
        queue.enQueue(23);
        queue.enQueue(532);
        queue.enQueue(12);
        queue.display();
        queue.reverse();
        queue.display();

        System.out.println("  ");

        queue.display();
        queue.reverseRecursion();
        queue.display();

    }
}