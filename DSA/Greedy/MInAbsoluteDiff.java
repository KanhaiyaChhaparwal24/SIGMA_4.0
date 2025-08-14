//Min Absolute Difference Pairs
// Given two arrays A and B of equal length n. Pair each element of array A to an element in array B, such that sum S of absolute differences of all the pairs is minimum.

import java.util.*;

public class MInAbsoluteDiff {
    public static int minAbsDiff(int[] A, int[] B) {
        // Sort both arrays
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        int sum = 0;
        // Calculate the sum of absolute differences
        for (int i = 0; i < n; i++) {
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 1, 3};
        System.out.println(minAbsDiff(A, B));
    }
}