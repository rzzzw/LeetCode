// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> res = new ArrayList<>();
//         int nrow = matrix.length;
//         int ncol = matrix[0].length;
//         int up = 0;
//         int left = 0;
//         int right = ncol - 1;
//         int down = nrow - 1;

//         while (res.size() < nrow * ncol) {
//             for (int col = left; col <= right; col++) {
//                 res.add(matrix[up][col]);
//             }
//             for (int row = up + 1; row <= down; row++) {
//                 res.add(matrix[row][right]);
//             }
//             if (up != down) {
//                 for (int col = right - 1; col >= left; col--) {
//                     res.add(matrix[down][col]);
//                 }
//             }
//             if (left != right) {
//                 for (int row = down - 1; row > up; row--) {
//                     res.add(matrix[row][left]);
//                 }
//             }
//             left++;
//             right--;
//             up++;
//             down--;
//         }
//         return res;
//     }
// }

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int up = 0;
        int left = 0;
        int down = nrow - 1;
        int right = ncol - 1;
        while (res.size() < nrow * ncol) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[up][col]);
            }
            for (int row = up + 1; row <= down; row++) {
                res.add(matrix[row][right]);
            }
            if (down != up) {
                for (int col = right - 1; col >= left; col--) {
                    res.add(matrix[down][col]);
                }
            }
            if (right != left) {
                for (int row = down - 1; row > up; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            up++;
            right--;
            down--;
        }
        return res;
    }
}