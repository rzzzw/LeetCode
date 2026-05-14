class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '*') {
                    q.offer(new int[]{r, c});
                } 
            }
        }

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : DIRS){
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                        continue;
                    } else if (grid[nr][nc] == '#') {
                        return steps + 1;
                    } else if (grid[nr][nc] == 'O') {
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 'X';
                    }
                }

            }
            steps++;
        }
        return -1;
    }

}


