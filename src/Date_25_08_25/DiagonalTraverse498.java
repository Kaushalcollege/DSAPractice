package Date_25_08_25;

public class DiagonalTraverse498 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = findDiagonalOrder(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++){
            // for every iteration, add the element to the result array
            result[i] = matrix[row][col];

            // if the sum of row and col is even, we are moving upwards-right
            if ((row + col) % 2 == 0){
                // if we are at the last column, we can only move down
                if (col == n - 1){
                    row++;  
                }
                else if (row == 0){ // if we are at the first row, we can only move right
                    col++;
                }
                else{ // otherwise, move diagonally up-right
                    row--;
                    col++;
                }
            }
            else{ // if the sum of row and col is odd, we are moving downwards-left
                // if we are at the last row, we can only move right
                if (row == m - 1){
                    col++;
                }
                else if (col == 0){ // if we are at the first column, we can only move down
                    row++;
                }
                else{ // otherwise, move diagonally down-left
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
