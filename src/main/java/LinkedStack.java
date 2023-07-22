public class LinkedStack {

    private Node top;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top != null) {
            int data = top.data;
            top = top.next;
            return data;
        } else {
            throw new IllegalStateException("Stack is empty!");
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(50);
        linkedStack.push(60);
        linkedStack.push(70);

        System.out.println("\nLinkedStack:");
        while (!linkedStack.isEmpty()) {
            System.out.println(linkedStack.pop());
        }
    }

}
