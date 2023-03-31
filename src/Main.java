import Stack.ArrayBasedStack;

public class Main {
    public static void main(String[] args) {
        ArrayBasedStack stack = new ArrayBasedStack(5);

        stack.push(100);
        stack.push(43);
        stack.push(2);
        stack.push(13);
        ArrayBasedStack stack2 = new ArrayBasedStack(5);

        stack2.push(12);
        stack2.push(2);
        stack2.push(43);
        stack2.push(100);

        System.out.println(stack2.isReversee(stack));

        stack.printStack();
    }
}