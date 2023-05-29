//package Queue;
//
//import Nodes.Node;
//import Stack.ArrayBasedStack;
//
//public class LinkedQueue implements Queue{
//
//    Node front = null;
//    Node rear = null;
//
//    public boolean isEmpty() {
//        return front == null;
//    }
//
//    public void enQueue(int data) {
//        Node newNode = new Node(data);
//        if (newNode == null) {
//            return;
//        }
//        if (rear == null) {
//            front = rear = newNode;
//        } else {
//            rear.next = newNode;
//            rear = newNode;
//        }
//    }
//
//    public Node deQueue() {
//        Node current = null;
//        if (front != null) {
//            current = front;
//            front = front.next;
//            if (front == null) {
//                rear = null;
//            }
//        }
//        return current;
//    }
//
//    public void display() {
//        Node currentNode = front;
//        while (currentNode != null) {
//            System.out.print(currentNode.data + " ");
//            currentNode = currentNode.next;
//        }
//    }
//
//    public int getMin() {
//        LinkedQueue tempQueue = new LinkedQueue();
//        Node min = front;
//
//        while (!isEmpty()) {
//            Node current = deQueue();
//            if (min.data > current.data) {
//                min = current;
//            }
//            tempQueue.enQueue(current.data);
//        }
//        while (!tempQueue.isEmpty()) {
//            enQueue(tempQueue.deQueue().data);
//        }
//        return min.data;
//    }
//
//    public int getMax() {
//        LinkedQueue tempQueue = new LinkedQueue();
//        Node max = front;
//        while (!isEmpty()) {
//            Node current = deQueue();
//            if (max.data < current.data) {
//                max = current;
//            }
//            tempQueue.enQueue(current.data);
//        }
//        while (!tempQueue.isEmpty()) {
//            enQueue(tempQueue.deQueue().data);
//        }
//        return max.data;
//    }
//
//    public int getSize() {
//        Node currentNode = front;
//        int counter = 0;
//        while (currentNode != null) {
//            counter++;
//            currentNode = currentNode.next;
//        }
//        return counter;
//    }
//
//    public boolean isEqual(LinkedQueue queue) {
//        Node current = front;
//        Node currentQueue2 = queue.front;
//
//        if (current == null && currentQueue2 == null) {
//            return true;
//        }
//        if (getSize() == queue.getSize()) {
//            while (current != rear) {
//                if (current.data != currentQueue2.data) {
//                    return false;
//                }
//                current = current.next;
//                currentQueue2 = currentQueue2.next;
//            }
//        }
//        return true;
//    }
//
//    // Reversing a queue with a Stack
//    public void reverse(){
//        ArrayBasedStack stack = new ArrayBasedStack(getSize());
//
//        while(!isEmpty()){
//            stack.push(deQueue().data);
//        }
//        while (!stack.isEmpty()){
//            enQueue(stack.pop());
//        }
//    }
//
//    public void reverseRecursion(){
//        if (!isEmpty()){
//            int element = deQueue().data;
//            reverseRecursion();
//            enQueue(element);
//        }
//    }
//
//}
