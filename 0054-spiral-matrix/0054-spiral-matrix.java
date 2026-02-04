class Solution{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1; 

        while (top <= bottom && left <= right) {
            // 1. top row
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // 2. right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 3. bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4. left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}