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
        
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                
                for (int[] dir : dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // Case 1 - out of boundry, handle with continue to skip
                    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) {
                        continue; 
                    }
                    
                    // Case 2 - cell value != Integer.MAX_VALUE(2^31-1), do nothing, don't offer to the queue
                    //      2.1: cell value == 0, are start cells in 2D BFS, value no change
                    //      2.2: cell value == -1(A wall or an obstacle), keep as -1
                    //      2.3: cell value == any other number, means already updated with a smallest step value in previous traverse.
                    if (rooms[x][y] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[x][y] = step;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
    }
}