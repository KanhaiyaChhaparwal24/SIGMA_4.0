public class LinkedList {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0; // Initialize size to 0

    public void addNode(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) { // Add at the beginning
            newNode.next = head;
            head = newNode;
            if (tail == null) { // If the list was empty
                tail = newNode;
            }
            size++; // Increment size after adding a node
            return;
        }

        if (position == -1 || head == null) { // Add at the end or if the list is empty
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++; // Increment size after adding a node
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1; i++) { // Traverse to the (position-1)th node
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds");
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) { // Update tail if added at the end
            tail = newNode;
        }
        size++; // Increment size after adding a node
    }

    public void removeNode(int position) {
        if (head == null) { // If the list is empty
            System.out.println("List is empty");
            return;
        }

        if (position == 0) { // Remove from the beginning
            head = head.next;
            if (head == null) { // If the list becomes empty
                tail = null;
            }
            size--; // Decrement size after removing a node
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1; i++) { // Traverse to the (position-1)th node
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) { // If position is out of bounds
            System.out.println("Position out of bounds");
            return;
        }

        temp.next = temp.next.next; // Remove the node
        if (temp.next == null) { // Update tail if the last node was removed
            tail = temp;
        }
        size--; // Decrement size after removing a node
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Size: " + size); // Print the size of the linked list
    }

    public boolean iterativeSearch(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true; // Key found
            }
            temp = temp.next;
        }
        return false; // Key not found
    }

    public boolean recursiveSearch(Node node, int key) {
        if (node == null) {
            return false; // Reached the end, key not found
        }
        if (node.data == key) {
            return true; // Key found
        }
        return recursiveSearch(node.next, key); // Recur for the next node
    }

    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next = null;
        tail = head; // Update tail to the current head

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to the current node
            current = next; // Move to the next node
        }

        head = prev; // Update head to the new head (last node of the original list)
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNode(1, -1); // Add at the end
        ll.addNode(2, -1); // Add at the end
        ll.addNode(0, 0);  // Add at the beginning
        ll.addNode(3, 2);  // Add in the middle
        ll.addNode(4, -1); // Add at the end
        ll.addNode(5, -1); // Add at the end

        ll.printList(); // Print the linked list

        ll.removeNode(2); // Remove the node at position 2
        ll.printList(); // Print the linked list after removal

        System.out.println("Iterative search for 2: " + ll.iterativeSearch(2)); // Example usage
        System.out.println("Recursive search for 3: " + ll.recursiveSearch(head, 3)); // Example usage

        ll.reverseList(); // Reverse the linked list
        ll.printList(); // Print the reversed linked list
    }
}