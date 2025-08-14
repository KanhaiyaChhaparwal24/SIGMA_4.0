
import java.util.ArrayList;
import java.util.Scanner;

public class MostFrequentFollowingKey {
    public static int mostFrequent(ArrayList<Integer> nums, int key){
        int[] result = new int[100];
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1)-1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.print("Enter the number of elements in the ArrayList: ");
        int n = sc.nextInt();
        
        System.out.print("Enter the elements of the ArrayList: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        System.out.println("The most frequent following key is: " + mostFrequent(list, key));
    }
}