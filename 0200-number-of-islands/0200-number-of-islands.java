class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        
        for (int[] d : DIRS) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }

}


// why not dfs(grid, r, c, islands) and return islands[0] in this problem?





/**
Time: O(m × n) Each cell is visited once

Space: O(m × n) worst-case recursion stack (all land)
 */