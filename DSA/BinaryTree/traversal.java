import java.util.LinkedList;
import java.util.Queue;

public class traversal {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Level-order (Breadth-First Search)
    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.value + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    // Height of the tree (number of levels)
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total nodes
    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Sum of all node values
    static int sumNodes(Node root) {
        if (root == null) return 0;
        return root.value + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.print("Level-order: ");
        levelOrder(root);
        System.out.println();

        System.out.println("Height of tree: " + height(root));
        System.out.println("Count of nodes: " + countNodes(root));
        System.out.println("Sum of nodes: " + sumNodes(root));
    }
}