class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>(); // common cells reachable from both oceans
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // height = matrix;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Loop through each cell adjacent to the oceans and start a DFS
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacificReachable, matrix);
            dfs(r, cols - 1, atlanticReachable, matrix);
        }

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacificReachable, matrix);
            dfs(rows - 1, c, atlanticReachable, matrix);
        }
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    res.add(List.of(r, c)); 
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] reachable, int[][] matrix) {
        reachable[r][c] = true; 
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= reachable.length || nc >= reachable[0].length) {
                continue;
            }
            if (reachable[nr][nc]) {
                continue;
            }
            if (matrix[nr][nc] < matrix[r][c]) {
                continue;
            }
            dfs(nr, nc, reachable, matrix);
        }
    }
}



// class Solution {
//     private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//     private int nCols;
//     private int nRows;
//     private int[][] height;

//     public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//         if (matrix.length == 0 || matrix[0].length == 0) {
//             return new ArrayList<>();
//         }
//         nRows = matrix.length;
//         nCols = matrix[0].length;
//         height = matrix;
//         boolean[][] pacificReachable = new boolean[nRows][nCols];
//         boolean[][] atlanticReachable = new boolean[nRows][nCols];
        
//         // Loop through each cell adjacent to the oceans and start a DFS
//         for (int i = 0; i < nRows; i++) {
//             dfs(i, 0, pacificReachable);
//             dfs(i, nCols - 1, atlanticReachable);
//         }
//         for (int i = 0; i < nCols; i++) {
//             dfs(0, i, pacificReachable);
//             dfs(nRows - 1, i, atlanticReachable);
//         }

//         List<List<Integer>> commonCells = new ArrayList<>();
//         for (int i = 0; i < nRows; i++) {
//             for (int j = 0; j < nCols; j++) {
//                 if (pacificReachable[i][j] && atlanticReachable[i][j]) {
//                     commonCells.add(List.of(i, j));
//                 }
//             }
//         }
//         return commonCells;
//     }

//     private void dfs(int row, int col, boolean[][] reachable) {
//         reachable[row][col] = true;
//         for (int[] dir : DIRECTIONS) {
//             int newRow = row + dir[0];
//             int newCol = col + dir[1];
//             if (newRow < 0 || newRow >= nRows || newCol < 0 || newCol >= nCols) {
//                 continue;
//             }  
//             if (reachable[newRow][newCol]) {
//                 continue;
//             }
//             if (height[newRow][newCol] < height[row][col]) {
//                 continue;
//             }
//             dfs(newRow, newCol, reachable);
//         }
//     }
// }