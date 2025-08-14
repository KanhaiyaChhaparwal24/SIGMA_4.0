package Apna_College.DSA.Patterns;
import java.util.Scanner;

public class p4 {

    public static void py10(int a ){

        for (int i = 1; i <= a ; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i+j) % 2 == 0) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        py10(m); ;
    }
}
