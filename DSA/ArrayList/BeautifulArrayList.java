import java.util.*;

public class BeautifulArrayList {
    public static ArrayList<Integer> BeautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConque(1, 1, res, n);
        return res;
    }
    private static void divideConque(int start, int incr, ArrayList<Integer> res, int n) {
        if (start + incr > n) {
            res.add(start);
            return;
        }
        divideConque(start, 2*incr, res, n);
        divideConque(start+incr, 2*incr, res, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println("The beautiful array is: " + BeautifulArray(n));
        sc.close();
    }
}