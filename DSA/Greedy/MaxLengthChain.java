// Max Length Chain of Pairs
// You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can come after pair (a, b) if b < c.
// Find the longest chain which can be formed from a given set of pairs.

import java.util.*;

public class MaxLengthChain {
    public static int findLongestChain(int[][] pairs) {
        // Sort based on the second element of the pair
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int chainLength = 0;
        int end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                chainLength++;
                end = pair[1];
            }
        }
        return chainLength;
    }
    public static void main(String[] args) {
        int[][] pairs = { {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90} };
        System.out.println(findLongestChain(pairs));
    }
}