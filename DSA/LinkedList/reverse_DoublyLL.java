public class reverse_DoublyLL {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data; // Fixed the assignment of data
            this.prev = null;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node temp = null;
        Node current = head;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Adjust head to point to the new front
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " "); // Correctly prints the data
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample doubly linked list: 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}
