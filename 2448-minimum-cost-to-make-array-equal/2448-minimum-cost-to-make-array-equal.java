class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = cost[i];
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);        
        
        // idx      0  1  2  3
        // num      1  2  3  5
        // cost     2 14  3  1
        // pref_L   2 16 19
        // left        2 18 18+19*2=56
        
        
        long[] left = new long[n];
        long preSumLeft = pairs[0][1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + preSumLeft * (pairs[i][0] - pairs[i - 1][0]);
            preSumLeft += pairs[i][1];
        }
        
        long[] right = new long[n];
        long preSumRight = pairs[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + preSumRight * (pairs[i + 1][0] - pairs[i][0]);
            preSumRight += pairs[i][1];
        }
        
        long res = right[0] + left[0];
        for (int i = 0; i < n; i++) {
            if (right[i] + left[i] < res) {
                res = right[i] + left[i];
            }            
        }
        return res;
    }
}