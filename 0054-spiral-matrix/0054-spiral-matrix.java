// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> res = new ArrayList<>();
//         if (matrix == null || matrix.length == 0) {
//             return res;
//         }
//         int top = 0, bottom = matrix.length - 1;
//         int left = 0, right = matrix[0].length - 1;
//         while (top <= bottom && left <= right) {
//             // 1.top row
//             for (int j = left; j <= right; j++) {
//                 res.add(matrix[top][j]);
//             }
//             top++;
            
//             // 2. right col
//             for (int i = top; i <= bottom; i++) {
//                 res.add(matrix[i][right]);
//             }
//             right--;

//             // 3. bottom row
//             if (top <= bottom) {
//                 for (int j = right; j >= left; j--) {
//                     res.add(matrix[bottom][j]);
//                 }
//                 bottom--;
//             }

//             // 4. left col
//             if (left <= right) {
//                 for (int i = bottom; i >= top; i--) {
//                     res.add(matrix[i][left]);
//                 }
//                 left++;                
//             }
//         }
//         return res;
//     }
// }

class Solution{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // 1.top row
            for (int c = left; c <= right; c++) {
                res.add(matrix[top][c]);
            }
            top++;

            // 2. right col
            for (int r = top; r <= bottom; r++) {
                res.add(matrix[r][right]);
            }
            right--;

            // 3. bottom row
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    res.add(matrix[bottom][c]);
                }
                bottom--;
            }

            // 4. left col
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    res.add(matrix[r][left]);
                }
                left++;
            }
        }
        return res;
    }
}