/* LIFO */
public class ArrayStack2 {
    private int[] stack;
    private int capacity;
    private int top = -1;

    public ArrayStack2(int capacity) {
        stack = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int data){
        if (isFull()){
            throw new IllegalStateException("Stack is overflow!");
        }
        top++;
        stack[top]=data;
    }

    public int pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
        return stack[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        ArrayStack2 stack = new ArrayStack2(5);
        stack.push(1);
        stack.push(20);
        stack.push(100);
        stack.push(134);
        stack.push(157);
      //  stack.push(189); //stack if overflow!
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}
