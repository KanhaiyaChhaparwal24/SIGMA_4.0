import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LonelyNumber {
    public static ArrayList<Integer> findLonelyNumbers(ArrayList<Integer> nums) {
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();
        Collections.sort(nums); // Sort the list to check adjacency

        for (int i = 0; i < nums.size(); i++) {
            boolean isLonely = true;

            if (i > 0 && nums.get(i) - nums.get(i - 1) == 1) {
                isLonely = false;
            }
            if (i < nums.size() - 1 && nums.get(i + 1) - nums.get(i) == 1) {
                isLonely = false;
            }

            if (isLonely) {
                lonelyNumbers.add(nums.get(i));
            }
        }
        return lonelyNumbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        
        System.out.print("Enter the number of elements in the ArrayList: ");
        int n = sc.nextInt();
        
        System.out.print("Enter the elements of the ArrayList: ");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        System.out.println("The lonely numbers are: " + findLonelyNumbers(nums));
        sc.close();
    }
}