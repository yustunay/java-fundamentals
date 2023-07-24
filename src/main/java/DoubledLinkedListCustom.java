public class DoubledLinkedListCustom {
    Node head;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public void delete(int data) {
        Node current = head;
        while (current.next != null) {

            if (current.data == data) {
                Node prevNode = current.prev;
                Node nextNode = current.next;
                if (prevNode != null)
                    prevNode.next = nextNode;
                else
                    head = nextNode;

                nextNode.prev = prevNode;
            }

            current = current.next;
        }

        if (current.data == data) {
            Node prevNode = current.prev;
            if (prevNode != null)
                prevNode.next = null;
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

    public void deleteOddNodes() {
        Node current = head;
        while (current.next != null) {

            if (current.data % 2 == 1) {
                Node prevNode = current.prev;
                Node nextNode = current.next;

                if (prevNode != null)
                    prevNode.next = nextNode;
                else
                    head = nextNode;

                nextNode.prev = prevNode;
            }
            current = current.next;
        }

        if (current.data % 2 == 1) {
            Node prevNode = current.prev;
            if (prevNode != null)
                prevNode.next = null;
        }
    }

    public static void main(String[] args) {
        DoubledLinkedListCustom list = new DoubledLinkedListCustom();
        list.append(1);
        list.append(6);
        list.append(12);
        list.append(21);
        list.append(28);
        list.append(31);
        list.append(46);
        list.append(49);
        list.append(51);
        list.append(67);
        list.printList();

        list.deleteOddNodes();
        list.printList();

//       list.delete(21);
//       list.printList();
//
//       list.delete(31);
//       list.printList();
    }
}
