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
        
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                rooms[row][col] = Math.min(rooms[row][col], step);
                
                for (int[] dir : dirs){
                    int x = row + dir[0];
                    int y = col + dir[1];
                    // Case 1 - out of boundry, handle with continue to skip
                    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) {
                        continue; 
                    }
                    
                    // Case 2 - cell value != Integer.MAX_VALUE(2^31-1), do nothing, don't offer to the queue
                    //      2.1: cell value == 0, all are considered initially, they will keep as 0 step to the nearest gate
                    //      2.2: cell value == -1(A wall or an obstacle), keep as -1
                    //      2.3: cell value == any other number, means already updated with a smallest step value in previous traverse.
                    if (rooms[x][y] != Integer.MAX_VALUE) {
                        continue;
                    }
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
    }
}