public class Matrices{
    public static void printSpiral(int matrix[][]) {
        int sRow = 0;
        int sCol = 0;
        int eRow = matrix.length - 1;
        int eCol = matrix[0].length - 1;

        while(sRow <= eRow && sCol <= eCol) {
            // top
            for (int j = sCol; j <= eCol; j++) {
                System.out.print(matrix[sRow][j]+ " ");
            }
            // right
            for (int i = sRow + 1; i <= eRow; i++) {
                System.out.print(matrix[i][eCol]+ " ");
            }
            // bottom
            for (int j = eCol - 1; j >= sCol; j--){
                if (sRow == eRow) {
                    break;
                }
                System.out.print(matrix[eRow][j]+ " ");
            }
            // left
            for (int i = eRow - 1; i >= sRow + 1; i--) {
                if (sCol == eCol) {
                    break;
                }
                System.out.print(matrix[i][sCol]+ " ");
            }
            sRow++;
            sCol++;
            eRow--;
            eCol--;
        }
        System.out.println();
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // O(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if (i == j){
        //             sum += matrix[i][j];
        //         }
        //         else if (i + j == matrix.length - 1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        // O(n)
        for (int i = 0; i < matrix.length; i++) {
            //pd
            sum += matrix[i][i];
            //sd
            if(i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == key) {
                System.out.println("Element found at: (" + row + " " + col + ")");
                return true;
            }
            else if (matrix[row][col] < key) {
                row++;
            }
            else {
                col--;
            }
        }
        System.out.println("Element not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};

        int matrix1[][] = {{10,20,30,40},
                           {15,25,35,45},
                           {27,29,37,48},
                           {32,33,39,50}};
        int key = 33;
        staircaseSearch(matrix1, key);
        // printSpiral(matrix);
        // System.out.println(diagonalSum(matrix));
    }
}