package Apna_College.DSA.Patterns;
import java.util.Scanner;

public class p8 {

    public static void diamond(int n){

        int a = n/2 ;

        for (int i = 1; i <= a ; i++) {
            for (int m = 1; m <= a-i; m++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

         for (int i = a; i >= 1  ; i--) {
            for (int m = 1; m <= a-i; m++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        diamond(m);
    }
}
