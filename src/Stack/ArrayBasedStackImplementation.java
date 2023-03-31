package Stack;

public class ArrayBasedStackImplementation implements Stack {
    private int top;
    private int size;
    private int[] array;

    public ArrayBasedStackImplementation(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            return array[top--];
        }
        return -1;
    }

    @Override
    public int peek() {
        if (!isEmpty()) {
            return array[top];
        }
        return -1;
    }

    @Override
    public boolean push(int element) {
        if (!isFull()) {
            array[++top] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public int size() {
        return size;
    }

    public void printStack() {
        if (!isEmpty()) {
            ArrayBasedStackImplementation temp = new ArrayBasedStackImplementation(size);

            while (!isEmpty()) {
                System.out.print(array[top] + " ");
                temp.push(pop());
            }

            System.out.println();
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
        }
    }

    // recursively
    public void printReversed() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        int temp = pop();
        printReversed();
        System.out.print(temp + " ");
        push(temp);
    }

//    public int max() {
//        int max;
//        while (!isEmpty()) {
//            max = pop();
//            if (max < peek()) {
//                max = pop();
//            }
//            if (isEmpty()){
//                return max;
//            }
//        }
//        return 0;
//    }

    public int max() {
        if (!isEmpty()) {
            int max = 0;
            for (int i = 0; i <= top; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;
        }
        return 0;
    }

    public int min() {
        if (!isEmpty()) {
            int min = array[0];
            for (int i = 0; i <= top; i++) {
                if (min > array[i]) {
                    min = array[i];
                }
            }
            return min;
        }
        return 0;
    }

    public int avg() {
        ArrayBasedStackImplementation temp = new ArrayBasedStackImplementation(size);
        int sum = 0;
        int counter = top + 1;

        while (!isEmpty()) {
            sum += peek();
            temp.push(pop());
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return sum / counter;
    }

    public boolean contains(int value) {
        boolean conatins = false;
        ArrayBasedStackImplementation temp = new ArrayBasedStackImplementation(size);

        while (!isEmpty()) {
            if (value == peek()) {
                conatins = true;
            }
            temp.push(pop());
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return conatins;
    }

    public boolean isEqual(ArrayBasedStackImplementation stack2) {
        ArrayBasedStackImplementation temp = new ArrayBasedStackImplementation(size);
        ArrayBasedStackImplementation tempStack2 = new ArrayBasedStackImplementation(stack2.size);

        if (isEmpty() && stack2.isEmpty()) {
            return true;
        }
        if (top == stack2.top) {
            while (!isEmpty()) {
                if (peek() != stack2.peek()) {
                    return false;
                }
                temp.push(pop());
                tempStack2.push(stack2.pop());
            }
            while (!temp.isEmpty()) {
                push(temp.pop());
                stack2.push(tempStack2.pop());
            }
        }
        return true;
    }

    public boolean isReversee(ArrayBasedStackImplementation stack2) {
        ArrayBasedStackImplementation temp = new ArrayBasedStackImplementation(size);
        ArrayBasedStackImplementation tempStack2 = new ArrayBasedStackImplementation(stack2.size);

        if (isEmpty() && stack2.isEmpty()) {
            return true;
        }
        if (top == stack2.top) {
            while (!stack2.isEmpty()) {
                tempStack2.push(stack2.pop());
            }
            while (!isEmpty()) {
                if (peek() != tempStack2.peek()) {
                    return false;
                }
                temp.push(pop());
                stack2.push(tempStack2.pop());
            }
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
        }
        return true;
    }

    private void pushReversed(int temp) {
        if (isEmpty()) {
            push(temp);
        } else {
            int temp2 = pop();
            pushReversed(temp);
            push(temp2);
        }
    }

    public void reverseStackRecursively() {
        if (!isEmpty()) {
            int temp = pop();
            reverseStackRecursively();
            pushReversed(temp);
        }
    }

    public void sortStack() {
        if (isEmpty()) {
            return;
        }

        int temp = pop();
        sortStack();
        insertInSortedOrder(temp);
    }

    private void insertInSortedOrder(int temp) {
        if (isEmpty() || peek() < temp) {
            push(temp);
        } else {
            int temp2 = pop();
            insertInSortedOrder(temp);
            push(temp2);
        }
    }

    public void sortStackUsingIteration() {
        ArrayBasedStackImplementation tempStack = new ArrayBasedStackImplementation(size);
        while (!isEmpty()) {
            int temp = pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

}