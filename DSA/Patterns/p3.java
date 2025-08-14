package Apna_College.DSA.Patterns;
import java.util.Scanner;

public class p3 {

    public static void invpyrwnos(int a ){

        int count = 1 ;
        for (int i = 1; i <= a ; i++) {
            for (int j = 1; j <= i; j++) {
               System.out.print(count + " ");
               count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        invpyrwnos(m); ;
    }
}
