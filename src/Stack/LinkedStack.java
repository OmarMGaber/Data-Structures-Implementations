
package Stack;

import Nodes.Node;

public class LinkedStack implements Stack {
    Node top = null;
    int size = 0;

    @Override
    public int pop() {
        if (top != null) {
            size--;
            int value = top.data;
            top = top.next;
            return value;
        }
        return 0;
    }

    @Override
    public int peek() {
        if (top != null) {
            return top.data;
        }
        return 0;
    }

    @Override
    public boolean push(int element) {
        Node newNode = new Node(element);
        if (newNode == null) {
            return false;
        }
        size++;
        newNode.next = top;
        top = newNode;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return 0;
    }

    public void display(){
        LinkedStack temp = new LinkedStack();
        while(!isEmpty()){
            int tempValue = pop();
            System.out.print(tempValue);
            temp.push(tempValue);
        }
        while (!temp.isEmpty()){
            push(temp.pop());
        }
    }

}
