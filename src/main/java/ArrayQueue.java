public class ArrayQueue {
    private int[] queue;
    private int front; // index of the front element
    private int rear; // index of the rear element
    private int size; // current number of elements in the queue

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0; // initially, both front and rear are at index 0
        rear = -1;
        size = 0; // queue is initially empty
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
        } else {
            rear = (rear + 1) % queue.length; // circular increment of rear index
            queue[rear] = value;
            size++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // or throw an exception
        } else {
            int value = queue[front];
            front = (front + 1) % queue.length; // circular increment of front index
            size--;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1; // or throw an exception
        } else {
            return queue[front];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued element: " + queue.dequeue()); // 10
        System.out.println("Peeked element: " + queue.peek()); // 20

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Is queue empty? " + queue.isEmpty()); // false
        System.out.println("Is queue full? " + queue.isFull()); // true
        System.out.println("Size: " + queue.getSize()); // 4
    }
}
