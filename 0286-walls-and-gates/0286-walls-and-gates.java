class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
              
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                rooms[row][col] = Math.min(step, rooms[row][col]);
                
                for (int[] dir : dirs) {
                    int x = dir[0] + row;
                    int y = dir[1] + col;
                    
                    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) continue;
                    if (rooms[x][y] != Integer.MAX_VALUE) continue;
                    
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
    }
}