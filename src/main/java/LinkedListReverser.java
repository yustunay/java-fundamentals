import java.util.LinkedList;

public class LinkedListReverser {

    public static void reverseLinkedList(LinkedList<Integer> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(size - 1 - i));
            linkedList.set(size - 1 - i, temp);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add elements to the linked list
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original linked list: ");
        printLinkedList(linkedList);

        // Reverse the linked list
        reverseLinkedList(linkedList);

        System.out.println("Reversed linked list: ");
        printLinkedList(linkedList);
    }

    public static void printLinkedList(LinkedList<Integer> linkedList) {
        for (Integer element : linkedList) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
