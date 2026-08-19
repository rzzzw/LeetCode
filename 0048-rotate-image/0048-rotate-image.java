// class Solution{
//     public void rotate(int[][] matrix) {
//         if (matrix == null || matrix.length <= 1) {
//             return;
//         }
//         transpose(matrix); // reflect over the hypotenuse
//         reflect(matrix); // reflect left & right 
//     }

//     private void transpose(int[][] matrix) {
//         int n = matrix.length;
//         for (int r = 0; r < n; r++) {
//             for (int c = r + 1; c < n; c++) {
//                 int temp = matrix[r][c];
//                 matrix[r][c] = matrix[c][r];
//                 matrix[c][r] = temp;
//             }
//         }
//     }

//     private void reflect(int[][] matrix) {
//         int n = matrix.length;
//         for (int r = 0; r <  n; r++) {
//             for (int c = 0; c < n / 2; c++) {
//                 int temp = matrix[r][c];
//                 matrix[r][c] = matrix[r][n - 1 - c];
//                 matrix[r][n - 1 - c] = temp;                
//             }
//         }
//     }
// }



/**
     j=0  j=1  j=2
i=0  [X]   .    .
i=1  [X]   *    .          * = center (stays put)
i=2   .    .    .

     j=0  j=1  j=2  j=3  j=4
i=0  [X]  [X]   .    .    .
i=1  [X]  [X]   .    .    .
i=2  [X]  [X]   *    .    .
i=3   .    .    .    .    .
i=4   .    .    .    .    .
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }        
        for (int i = 0; i < (n + 1)/ 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}


/*
1. Swap across the diagonal:   matrix[i][j] ↔ matrix[j][i]
2. Reverse each row: [a, b, c] → [c, b, a]
        147      741
        258  ->  852
        369      963

        14      21
        25      54
*/



// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         if (n <= 1) {
//             return;
//         }
//         for (int level = 0; level < n; level++) {
//             int right = n - 2 - level;
//             for (int i = level; i <= right; i++) {
//                 int temp = matrix[level][i];
//                 matrix[level][i] = matrix[n - 1 - i][level];
//                 matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
//                 matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
//                 matrix[i][n - 1 - level] = temp;
//             }
//         }
//     }
// }

