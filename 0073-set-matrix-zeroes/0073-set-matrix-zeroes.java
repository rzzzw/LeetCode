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

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }  
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }      
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        } 
        if (firstRowZero == true) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }            
        if (firstColZero == true) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}






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