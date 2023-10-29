class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // Sort by ending points
        int n = events.length;
        int[][] dp = new int[n+1][k+1];
        int res = 0;

        for (int i = 1; i <= n; i++) {  // O(n)
            for (int t = 1; t <= Math.min(i, k); t++) {  // O(k)
                /**
                compute dp[i][t]: the maximum value by attending at most t events with previous i events

                option 1: do not choose the i-th event => initial value: dp[i-1][t] 
                          the number of event attend t keep no change
                option 2: choose the i-th event, concat with the previous no overlapping event        
                          t <- t-1,  + cur value    

               
                 */
                int prevNonOverlappingEvent = searchEvent(events, events[i-1][0]) - 1; // O(logn)
                dp[i][t] = Math.max(dp[i-1][t], dp[prevNonOverlappingEvent + 1][t-1] + events[i-1][2]); // dp[] idx off by 1, so prevNonOverlappingEvent+1
                res = Math.max(res, dp[i][t]);
            }
        }
        return res;
    }

    private int searchEvent(int[][] events, int target) {  // find the first event with ending point >= target
        int left = 0;
        int right = events.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}



/**

        1  2  3  4
        ————
           ————
              ————

Sort by end day
dp[i][t]: the maximum value by attending at most t events with previous i events
return dp[n][k]

idx          0       1       2
events：  [1,2,4],[3,4,3],[2,3,1]


n = 3       1       2       3
                    i
            j
 */