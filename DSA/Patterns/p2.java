package Apna_College.DSA.Patterns;
import java.util.Scanner;

public class p2 {

    public static void invhalfpyr(int a ){

        for (int i = 1; i <= a ; i++) {
            for (int j = 1; j <= a; j++) {
                if (i+j > a) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        invhalfpyr(m); ;
    }
}
