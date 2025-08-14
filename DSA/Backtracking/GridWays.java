public class GridWays {

    public static int countWays(int i, int j, int m, int n) {
        // out of the grid
        if (i >= m || j >= n) {
            return 0;
        }
        // bottom-right corner
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Move right and down recursively
        int rightWays = countWays(i, j + 1, m, n);
        int downWays = countWays(i + 1, j, m, n);

        return rightWays + downWays;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        int totalWays = countWays(0, 0, m, n);
        System.out.println("Total number of ways: " + totalWays);
    }
}