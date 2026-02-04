class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix); // Swap across the diagonal:   matrix[i][j] ↔ matrix[j][i]
        reflect(matrix); // Reverse each row: [a, b, c] → [c, b, a]
    }
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}


// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         if (n <= 1) {
//             return;
//         }

//         int round = n / 2; 
//         for (int level = 0; level < round; level++){  // 控制从外到内，需要操作几层
//             int right = n - 2 - level;  // rightest idx = n - 1, spiral的话要再 minus 1 -> so, n - 2
//             for (int i = level; i <= right; i++) {
//                 int temp = matrix[level][i];
//                 matrix[level][i] = matrix[n - 1 - i][level];  // 关键： 哪个是fix的？
//                 matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
//                 matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
//                 matrix[i][n - 1 - level] = temp;
//             }
//         }
//     }
// }


