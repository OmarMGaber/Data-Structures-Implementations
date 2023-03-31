import Stack.ArrayBasedStackImplementation;
import Stack.StackLinkedImplementation;

public class Main {
    public static void main(String[] args) {
        ArrayBasedStackImplementation stack = new ArrayBasedStackImplementation(5);

        stack.push(100);
        stack.push(43);
        stack.push(2);
        stack.push(13);
        ArrayBasedStackImplementation stack2 = new ArrayBasedStackImplementation(5);

        stack2.push(12);
        stack2.push(2);
        stack2.push(43);
        stack2.push(100);

        System.out.println(stack2.isReversee(stack));

        stack.printStack();
    }
}