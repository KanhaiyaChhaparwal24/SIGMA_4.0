import java.util.ArrayList;
import java.util.Scanner;

public class MonotonicArrayList {
    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                increasing = false;
            }
            if (list.get(i) < list.get(i + 1)) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }   // O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.print("Enter the number of elements in the ArrayList: ");
        int n = sc.nextInt();
        
        System.out.print("Enter the elements of the ArrayList: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        System.out.println("Is the ArrayList monotonic? " + isMonotonic(list));
        sc.close();
    }
}