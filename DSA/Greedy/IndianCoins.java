// We are given infinite supply of Indian coins of denominations 1, 2, 5, 10, 20, 50, 100, 500, 2000.
// Find minimum number of coins/notes to make change for a value V.

import java.util.*;

public class IndianCoins {
    public static int minCoins(int V) {
        int[] coins = {2000, 500, 100, 50, 20, 10, 5, 2, 1};
        int count = 0;
        ArrayList<Integer> usedCoins = new ArrayList<>();
        for (int coin : coins) {
            while (V >= coin) {
                V -= coin;
                usedCoins.add(coin);
                count++;
            }
        }
        System.out.println("Coins used: " + usedCoins);
        return count;
    }
    public static void main(String[] args) {
        int V = 590;
        System.out.println(minCoins(V));
    }
}