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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowZero.contains(i) || colZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
 }