package Queue;

public class ArrayBasedQueue {
    int size;
    int[] array;
    int front;
    int rear;

    public ArrayBasedQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        array = new int[size];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean enQueue(int element) {
        if (!isFull()) {
            if (rear == -1) {
                rear = front = 0;
                array[front] = element;
            } else {
                rear = (rear + 1) % size;
                array[rear] = element;
            }
            return true;
        } else {
            return false;
        }
    }

    public int deQueue() {
        if (!isEmpty()) {
            int value = array[front];

            if (front == rear) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return value;
        }
        return -1;
    }

    public void display() {
        ArrayBasedQueue tempQueue = new ArrayBasedQueue(size);

        while (!isEmpty()) {
            tempQueue.enQueue(deQueue());
        }
        while(!tempQueue.isEmpty()){
            int element = tempQueue.deQueue();
            System.out.print(element + " ");
            enQueue(element);
        }
    }
}

