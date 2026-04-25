// class Solution {
//     public void rotate(int[][] matrix) {
//         transpose(matrix); // Swap across the diagonal:   matrix[i][j] ↔ matrix[j][i]
//         reflect(matrix); // Reverse each row: [a, b, c] → [c, b, a]
//     }
//     private void transpose(int[][] matrix) {
//         int n = matrix.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
//     }
//     private void reflect(int[][] matrix) {
//         int n = matrix.length;
//         for (int i = 0; i < n; i++) {
//             int l = 0;
//             int r = n - 1;
//             while (l < r) {
//                 int temp = matrix[i][l];
//                 matrix[i][l] = matrix[i][r];
//                 matrix[i][r] = temp;
//                 l++;
//                 r--;
//             }
//         }
//     }
// }

/*
1. Swap across the diagonal:   matrix[i][j] ↔ matrix[j][i]
2. Reverse each row: [a, b, c] → [c, b, a]
        147      741
        258  ->  852
        369      963
*/



class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        int round = n / 2;
        for (int level = 0; level < n; level++) {
            int right = n - 2 - level;
            for (int i = level; i <= right; i++) {
                int temp = matrix[level][i];
                matrix[level][i] = matrix[n - 1 - i][level];
                matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
                matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
                matrix[i][n - 1 - level] = temp;
            }
        }
    }
}

/**
n = 9: 

        0 1 2 3 4 5 6 7 8

0       - - - - - - - - #
1       @ - - - - - - # #
2       @ @ # # # # # # #
3       @ @ # # # # # # #
4       @ @ # # # # # # #
5       @ @ # # # # # # #
6       @ @ # # # # # # #
7       @ @ % % % % % % #
8       @ % % % % % % % %


 */