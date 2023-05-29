import Collections.StackCollections;

import Stack.ArrayBasedStack;
import Stack.LinkedStack;

public class Main {
    public static void main(String[] args) {
        Collections.StackCollections stackCollections = new StackCollections();

        LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        linkedStack.push(6);

        System.out.println("LinkedStack: " + linkedStack);


        ArrayBasedStack<Integer> stack = new ArrayBasedStack<Integer>(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack: " + stack);

        System.out.println(stackCollections.isEqual(stack, linkedStack));
    }
}