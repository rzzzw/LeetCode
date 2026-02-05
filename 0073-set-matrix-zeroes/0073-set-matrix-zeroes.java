/**
[1, 1]:
    [1, x] <- row
    [x, 1] <- col

[0, 0]:
    [0, x] <- row
    [x, 0] <- col

[0, 3]:
    [0, x] <- row
    [x, 3] <- col



 */
//  class Solution {
//     public void setZeroes(int[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return;
//         }
//         Set<Integer> rowZero = new HashSet<>();
//         Set<Integer> colZero = new HashSet<>();
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == 0) {
//                     rowZero.add(i);
//                     colZero.add(j);
//                 }
//             }
//         }
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (rowZero.contains(i) || colZero.contains(j)) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//         return;
//     }
//  }

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < cols; i++) {
            if(matrix[0][i] == 0) {
                firstRowZero = true;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0|| matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
        if (firstColZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
        
    }
}

// class Solution{
//     public void setZeroes(int[][] matrix) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         boolean firstRowZero = false;
//         boolean firstColZero = false;
//         for (int i = 0; i < cols; i++) {
//             if (matrix[0][i] == 0) {
//                 firstRowZero = true;
//             }
//         }
//         for (int i = 0; i < rows; i++) {
//             if (matrix[i][0] == 0) {
//                 firstColZero = true;
//             }
//         }
//         for (int c = 1; c < cols; c++) {
//             for (int r = 1; r < rows; r++) {
//                 if (matrix[r][c] == 0) {
//                     matrix[r][0] = 0;
//                     matrix[0][c] = 0;
//                 }
//             }
//         }
//         for (int c = 1; c < cols; c++) {
//             for (int r = 1; r < rows; r++) {
//                 if (matrix[r][0] == 0 || matrix[0][c] == 0) {
//                     matrix[r][c] = 0;
//                 }
//             }
//         }
//         if (firstRowZero) {
//             for (int c = 0; c < cols; c++) {
//                 matrix[0][c] = 0;
//             }
//         }
//         if (firstColZero) {
//             for (int r = 0; r < rows; r++) {
//                 matrix[r][0] = 0;
//             }
//         }
//     }
// }