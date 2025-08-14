import java.util.ArrayList;

public class PairSum1 {
    // Brute force approach
    public static boolean hasPairWithSumBruteForce(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }   // O(n^2)

    // Two-pointer approach
    public static boolean hasPairWithSumTwoPointer(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }   // O(n)

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int target = 5;

        System.out.println("Brute Force: " + hasPairWithSumBruteForce(list, target));
        System.out.println("Two Pointer: " + hasPairWithSumTwoPointer(list, target));
    }
}
