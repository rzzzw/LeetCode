class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int nCols;
    private int nRows;
    private int[][] height;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        nRows = matrix.length;
        nCols = matrix[0].length;
        height = matrix;
        boolean[][] pacificReachable = new boolean[nRows][nCols];
        boolean[][] atlanticReachable = new boolean[nRows][nCols];
        
        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < nRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, nCols - 1, atlanticReachable);
        }
        for (int i = 0; i < nCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(nRows - 1, i, atlanticReachable);
        }

        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= nRows || newCol < 0 || newCol >= nCols) {
                continue;
            }  
            if (reachable[newRow][newCol]) {
                continue;
            }
            if (height[newRow][newCol] < height[row][col]) {
                continue;
            }
            dfs(newRow, newCol, reachable);
        }
    }
}