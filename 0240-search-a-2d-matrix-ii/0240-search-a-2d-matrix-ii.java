class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols - 1; // start from top-right

        while (r < rows && c >= 0) {
            int val = matrix[r][c];
            if (val == target) {
                return true;
            } else if (val > target) {
                c--;    // eliminate column
            } else {
                r++;    // eliminate row
            }
        }
        return false;
    }
}