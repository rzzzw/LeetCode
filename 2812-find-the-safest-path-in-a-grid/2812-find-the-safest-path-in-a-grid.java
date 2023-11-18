class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                int[] cur = q.poll(); 
                for (int k = 0; k < 4; k++) {
                    int i = cur[0] + dir[k][0]; 
                    int j = cur[1] + dir[k][1]; 
                    if (i < 0 || i >= n || j < 0 || j >= n) {
                        continue;
                    }
                    if (grid.get(i).get(j) != 0) {
                        continue;
                    }
                    grid.get(i).set(j, grid.get(cur[0]).get(cur[1]) + 1); 
                    q.offer(new int[]{i, j});
                }
                len--;
            }
        }
        int left = 0; 
        int right = 2 * n;
        while (left < right) {      // l: 0   r: 1  => m: 0
            // int mid = left + (right - left) / 2; // deadloop. need modify the condition to left < right - 1, and add a post processing
            int mid = right - (right - left) / 2;
            if (isPathExist(grid, mid)){ 
                left = mid;  
            } else {
                right = mid - 1;
            }
        }
        // if (isPathExist(grid, left + 1)) {
        //     return left + 1;
        // }
        return left;
    }

    private boolean isPathExist(List<List<Integer>> grid, int d) { // is there a path from (0,0) to (n-1, n-1) that each step > d
        int n = grid.size();
        int[][] visited = new int[n][n];
        if (grid.get(0).get(0) <= d) {
            return false;
        }        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int i = cur[0] + dir[k][0]; 
                int j = cur[1] + dir[k][1]; 
                if (i < 0 || i >= n || j < 0 || j >= n) continue;
                if (visited[i][j] != 0) continue;
                if (grid.get(i).get(j) <= d) continue;
                
                if (i == n-1 && j == n-1) return true;
                q.offer(new int[]{i, j});
                visited[i][j] = 1;
            }
        }
        return false;
    }
}


/**
example 1:
    0   0   1
    0   0   0
    1   0   0

    3.  2.  1.
    2.  3.  2.
    1.  2.  3.


q: 
[0,0][1,1][2,2]
len = 0
cur = [2,1]

l: 0
r: 6
m: 3

example 2:
    0   0   1
    0   0   0
    0   0   0

    3.  2.  1.
    4.  3.  2.
    5   4   3

example 2:
    0   1   1
    0   0   0
    0   0   0

    2   1.  1.
    3   2.  2.
    4   3   3

d in [0, 6]: if d = 3, grid.get(0).get(0) = 2 < d => narrow down the range of d 
d in [0, 2]: if d = 1

example 4:
    0   0   0   1
    0   0   0   0
    0   0   0   0
    1   0   0   0

    4   3.  2.  1.
    3   4   3.  2.
    2.  3   4   3.
    1.  2.  3   4
 */