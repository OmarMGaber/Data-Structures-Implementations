package Collections;

import Stack.*;

public class StackCollections<T extends Comparable<T>> {
    // Q.01: Reverse a Stack(recursively)
    public void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        T element = stack.pop();
        reverse(stack);
        pushReversed(stack, element);
    }

    private void pushReversed(Stack<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        T top = stack.pop();
        pushReversed(stack, element);
        stack.push(top);
    }

    // Q.02: Get minimum element from a stack
    public T getMin(Stack<T> stack) {
        T min = stack.peek();
        ArrayBasedStack<T> tempStack = new ArrayBasedStack<T>(stack.size());

        while (!stack.isEmpty()) {
            if (min.compareTo(stack.peek()) == 1) {
                tempStack.push(stack.pop());
                min = tempStack.peek();
            } else {
                tempStack.push(stack.pop());
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return min;
    }

    //Q.03: Get maximum element from a stack
    public T getMax(Stack<T> stack) {
        T max = stack.peek();
        ArrayBasedStack<T> tempStack = new ArrayBasedStack<T>(stack.size());

        while (!stack.isEmpty()) {
            if (max.compareTo(stack.peek()) == -1) {
                tempStack.push(stack.pop());
                max = tempStack.peek();
            } else {
                tempStack.push(stack.pop());
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return max;
    }

    //Q.04: get the average of the elements from a stack
    public double getAverage(Stack<T> stack) {
        double sum = 0.0;
        double size = 0;
        ArrayBasedStack<T> tempStack = new ArrayBasedStack<T>(stack.size());

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            sum += Double.valueOf(String.valueOf(tempStack.peek()));
            size++;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return (sum / size);
    }

    //Q.05: Check if the stack contains a specific value
    public boolean contains(Stack<T> stack, T element) {
        boolean contains = false;
        ArrayBasedStack<T> tempStack = new ArrayBasedStack<T>(stack.size());
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            if (element.compareTo(tempStack.peek()) == 0) {
                contains = true;
                break;
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return contains;
    }

    //Q.06: Check if two stacks are equal
    public boolean isEqual(Stack<T> stack1, Stack<T> stack2) {
        boolean isEqual = true;
        ArrayBasedStack<T> tempStack1 = new ArrayBasedStack<T>(stack1.size());
        ArrayBasedStack<T> tempStack2 = new ArrayBasedStack<T>(stack2.size());

        if (stack1.isEmpty() && stack2.isEmpty()) {
            isEqual = true;
        } else if ((stack1.isEmpty() && !stack2.isEmpty()) || (!stack1.isEmpty() && stack2.isEmpty())) {
            isEqual = false;
        } else if (stack1.size() == stack2.size()) {
            while (!stack1.isEmpty()) {
                tempStack1.push(stack1.pop());
                tempStack2.push(stack2.pop());
                if ((tempStack1.peek()).compareTo(tempStack2.peek()) != 0) {
                    isEqual = false;
                }
            }
        } else {
            isEqual = false;
        }

        while (!tempStack1.isEmpty()) {
            stack1.push(tempStack1.pop());
            stack2.push(tempStack2.pop());
        }

        return isEqual;
    }

    //Q.07: Check if two stacks are the reverse of each other
    public boolean isReverse(Stack<T> stack1, Stack<T> stack2) {
        reverse(stack2);
        boolean isReverse = isEqual(stack1, stack2);
        reverse(stack2);
        return isReverse;
    }

    //Q.08: Sort a stack using recursion
    public void sortRecursive(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }

        T temp = stack.pop();
        sortRecursive(stack);
        pushSorted(temp, stack);
    }

    private void pushSorted(T element, Stack<T> stack){
        if (stack.isEmpty()){
            stack.push(element);
        } else {
            T temp = stack.peek();
            if (element.compareTo(temp) >= 0){
                stack.push(element);
            } else {
                temp = stack.pop();
                pushSorted(element, stack);
                stack.push(temp);
            }
        }
    }

    //Q.09: Sort a stack using iteration
    public void sort(Stack<T> stack){
        ArrayBasedStack<T> tempStack = new ArrayBasedStack<T>(stack.size());
        T temp;
        while (!stack.isEmpty()){
            temp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) < 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }
}
