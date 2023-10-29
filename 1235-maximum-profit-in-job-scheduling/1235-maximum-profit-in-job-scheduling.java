class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] events = new int[n][3];
        for (int i = 0; i < n; i++) {
            events[i][0] = startTime[i];
            events[i][1] = endTime[i];
            events[i][2] = profit[i];
        }
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        
        int[] dp = new int[n + 1]; // the maximum value can get at in previous i events
        
        for (int i = 1; i <= n; i++) {
            int prevNonOverlappingEvent = searchEvent(events, events[i - 1][0]) - 1; // WIF target = 3 (events[2][0]) => prevNonOverlappingEvent = 0
            dp[i] = Math.max(dp[i - 1], dp[prevNonOverlappingEvent + 1] + events[i - 1][2]); // dp[] idx off by 1
        }
        return dp[n];
    }
    
    private int searchEvent(int[][] arr, int target) { // find the first event with endingPoint > the target
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][1] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/*
        1   2   3   4   5   6
1 50    _________
2 10        _________
3 40            _________
4 70            _____________
     
        0   1   2   3   4
  dp    0   50      

*/