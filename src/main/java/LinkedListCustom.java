public class LinkedListCustom {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Print a new line after printing all elements
    }

    public static void main(String[] args) {
        LinkedListCustom list = new LinkedListCustom();
        list.append(10);
        list.append(20);
        list.append(30);
        list.printList();
    }
}
