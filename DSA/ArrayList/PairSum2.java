import java.util.ArrayList;

public class PairSum2 {
    // Brute force approach
    public static boolean pairSumBruteForce(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Two-pointer approach
    public static boolean pairSumTwoPointer(ArrayList<Integer> list, int target) {
        // Find the pivot (smallest element index)
        int n = list.size();
        int pivot = -1;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        // Initialize two pointers
        int left = (pivot + 1) % n; // smallest element
        int right = pivot;         // largest element

        // Two-pointer logic
        while (left != right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                left = (left + 1) % n; // move left pointer forward
            } else {
                right = (n + right - 1) % n; // move right pointer backward
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        // Test brute force approach
        System.out.println("Brute Force: " + pairSumBruteForce(list, target));

        // Test two-pointer approach
        System.out.println("Two Pointer: " + pairSumTwoPointer(list, target));
    }
}
