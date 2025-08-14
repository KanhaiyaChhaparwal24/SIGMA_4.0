// We are given a bar of chocolate composed of m × n square pieces. One should break the chocolate into single squares. Parts of the chocolate may be broken along the vertical and horizontal lines as indicated by the broken lines in the picture.
// A single break of a part of the chocolate along a chosen vertical or horizontal line divides that part into two smaller ones. Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2 ... xm-1 and along horizontal lines with y1, y2 ... yn-1.
// The cost of breaking the whole bar into single squares is the sum of the successive breaks. One should compute the minimal cost of breaking the whole chocolate into single squares.
// For example, if we break the chocolate presented in the picture first along the horizontal lines, and next each obtained part along vertical lines then the cost of that breaking will be y1+y2+y3+4×(x1+x2+x3+x4+x5).

import java.util.*;

public class Chocola {
    public static int minCost(int[] x, int[] y) {
        // Sort the costs in descending order
        Arrays.sort(x);
        Arrays.sort(y);
        int m = x.length;
        int n = y.length;
        int i = m - 1, j = n - 1;
        int cost = 0;
        int hCount = 1, vCount = 1;
        // While there are still pieces to break
        while (i >= 0 && j >= 0) {
            // If the horizontal cost is greater
            if (x[i] > y[j]) {
                cost += x[i] * vCount; // Multiply by vertical count
                hCount++; // Increase horizontal count
                i--; // Move to the next horizontal cost
            } else {
                cost += y[j] * hCount; // Multiply by horizontal count
                vCount++; // Increase vertical count
                j--; // Move to the next vertical cost
            }
        }
        // If there are remaining horizontal costs
        while (i >= 0) {
            cost += x[i] * vCount; // Multiply by vertical count
            i--; // Move to the next horizontal cost
        }
        // If there are remaining vertical costs
        while (j >= 0) {
            cost += y[j] * hCount; // Multiply by horizontal count
            j--; // Move to the next vertical cost
        }
        return cost; // Return the total cost
    }
    public static void main(String[] args) {
        int[] x = {2, 1, 3, 1, 4};
        int[] y = {4, 1, 2};
        System.out.println(minCost(x, y));
    }    
}