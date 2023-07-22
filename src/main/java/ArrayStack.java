public class ArrayStack {
    private int[] stack;
    private int top; // index of the top element

    public ArrayStack(int capacity) {
        stack = new int[capacity];
        top = -1; // stack is initially empty
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full. Cannot push element.");
        } else {
            top++;
            stack[top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // or throw an exception
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1; // or throw an exception
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Peeked element: " + stack.peek()); // 20

        stack.push(40);
        stack.push(50);

        System.out.println("Is stack empty? " + stack.isEmpty()); // false
        System.out.println("Is stack full? " + stack.isFull()); // true
    }
}
