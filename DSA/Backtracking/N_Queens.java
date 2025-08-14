public class N_Queens {
    public static void nQueens(int[][] board, int row, int n) {
        //base case
        if(row == n) {
            printBoard(board, n);
            count++;
            System.out.println();
            return;
        }
        //recursive case
        for(int col=0;col<n;col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 1;
                nQueens(board, row+1, n);
                board[row][col] = 0;
            }
        }
    }
    public static void printBoard(int[][] board, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        //check for column
        for(int i=0;i<row;i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        //check for left diagonal
        int i = row;
        int j = col;
        while(i>=0 && j>=0) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        //check for right diagonal
        i = row;
        j = col;
        while(i>=0 && j<n) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    static int count = 0;
    
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        nQueens(board, 0, n);
        System.out.println("Total number of solutions: " + count);
    }
}