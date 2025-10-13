class Solution {
    private static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] heightsOri;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Check if input is empty
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        // Save initial values to parameters
        numRows = heights.length;
        numCols = heights[0].length;
        heightsOri = heights;

        // Setup each queue with cells adjacent to their respective ocean
        // any problem with repeat cell?
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            pacificQ.offer(new int[]{i, 0});
            atlanticQ.offer(new int[]{i, numCols - 1});
        }
        for (int i = 0; i < numCols; i++) {
            pacificQ.offer(new int[]{0, i});
            atlanticQ.offer(new int[]{numRows - 1, i});            
        }
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] reachPacific = bfs(pacificQ);
        boolean[][] reachAtlantic = bfs(atlanticQ);

        // Find all cells that can reach both Oceans
        List<List<Integer>> commonGrids = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (reachPacific[i][j] && reachAtlantic[i][j]) {
                    commonGrids.add(List.of(i,j));
                }
            }
        }
        return commonGrids;
    }

    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // this cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRS) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                // check if new grid is in-bound
                if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols) continue;

                // Make sure that the new grid hasn't already been visited
                if (reachable[newR][newC]) continue;

                // Check that the new grid is >= current height.
                if (heightsOri[newR][newC] < heightsOri[cell[0]][cell[1]]) continue;

                queue.offer(new int[]{newR, newC});
            }
        }
        return reachable;
    }
}