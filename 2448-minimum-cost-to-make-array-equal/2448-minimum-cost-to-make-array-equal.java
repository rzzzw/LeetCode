class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = cost[i];
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);        
        
        // treat cost as the repeat qty of nums
        long totalCount = 0;
        for (int i : cost) {
            totalCount += i;
        }
        
        long count = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            count += pairs[i][1];
            if (count >= totalCount * 1.0 / 2) {
                idx = i;
                break;
            }
        }
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(pairs[i][0] - pairs[idx][0]) * 1.0 * pairs[i][1];
        }
        
        return res;        
        
    }
}