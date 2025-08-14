package Apna_College.DSA.Patterns;
import java.util.Scanner;

public class p7 {

    public static void hollrhom(int a ){

        for (int i = 1; i <= a ; i++) {
            for (int m = 1; m <= a-i; m++) {
                System.out.print(" ");
            }
            if (i == 1 || i == a) {
                for (int n = 1; n <= a; n++) {
                    System.out.print("*");
                }
            }
            else {
                System.out.print("*");
                for (int n = 1; n <= a-2 ; n++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        hollrhom(m); ;
    }
}
