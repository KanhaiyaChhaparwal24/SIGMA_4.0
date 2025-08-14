public class diameter_of_bt {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    // Recursive function to find height and update diameter
    static int diameterRecur(Node root, int[] res) {
        if (root == null)
            return 0;

        int lHeight = diameterRecur(root.left, res);
        int rHeight = diameterRecur(root.right, res);

        res[0] = Math.max(res[0], lHeight + rHeight);

        return 1 + Math.max(lHeight, rHeight);
    }

    // Function to get diameter of the binary tree
    static int diameter(Node root) {
        int[] res = new int[1]; // store max diameter found
        diameterRecur(root, res);
        return res[0];
    }

    public static void main(String[] args) {
        /*
              5
             / \
            8   6
           / \  /
          3  7 9
        */
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);

        System.out.println(diameter(root));
    }
}