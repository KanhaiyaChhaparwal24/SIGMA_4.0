import java.util.*;

public class stackB {
    static class LinkedListStack {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;

        LinkedListStack() {
            this.head = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        public int size() {
            int size = 0;
            Node current = head;
            while (current != null) {
                size++;
                current = current.next;
            }
            return size;
        }

        public void printStack() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void clear() {
            head = null;
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        public void sort() {
            ArrayList<Integer> list = new ArrayList<>();
            Node current = head;
            while (current != null) {
                list.add(current.data);
                current = current.next;
            }
            Collections.sort(list);
            head = null;
            for (int i = list.size() - 1; i >= 0; i--) {
                push(list.get(i));
            }
        }
    }

    static class ArrayListStack {
        ArrayList<Integer> stack = new ArrayList<>();

        public boolean isEmpty() {
            return stack.size() == 0;
        }

        public void push(int data) {
            stack.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return stack.get(stack.size() - 1);
        }

        public int size() {
            return stack.size();
        }

        public void printStack() {
            for (int i = stack.size() - 1; i >= 0; i--) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();
        }

        public void clear() {
            stack.clear();
        }

        public void reverse() {
            Collections.reverse(stack);
        }

        public void sort() {
            Collections.sort(stack);
        }
    }

    public static void main(String[] args) {
        // Example usage of LinkedListStack
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(10);
        linkedListStack.push(20);
        linkedListStack.push(30);
        linkedListStack.printStack(); // Output: 30 20 10

        // Example usage of ArrayListStack
        ArrayListStack arrayListStack = new ArrayListStack();
        arrayListStack.push(5);
        arrayListStack.push(15);
        arrayListStack.push(25);
        arrayListStack.printStack(); // Output: 25 15 5

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack size: " + stack.size()); // Output: Stack size: 3
        System.out.println("Top element: " + stack.peek()); // Output: Top element: 3
        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: 3
        //print the stack after popping
        System.out.print("Stack after popping: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
    }
}