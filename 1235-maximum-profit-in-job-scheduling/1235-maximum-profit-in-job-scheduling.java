// idx          0   1   2   3
// start        1,  2,  3,  3
// end          3,  4,  5,  6
// profit       50, 10, 40, 70
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // sort by end time

        int[] dp = new int[n]; // max profit using jobs[0...i]
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int take = jobs[i][2];

            int j = findLastNonOverlap(jobs, i);
            if (j != -1) {
                take += dp[j];
            }

            dp[i] = Math.max(dp[i - 1], take);
        }
        return dp[n - 1];
    }

    private int findLastNonOverlap(int[][] jobs, int i) {
        int left = 0, right = i - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs[mid][1] <= jobs[i][0]) {
                if (mid + 1 <= right && jobs[mid + 1][1] <= jobs[i][0]) {  // check if there’s a better (more right) answer, shrink the range OR find the answer
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}



    

/*
DP definition:
        dp[i] = max profit using jobs[0...i]

Transition
    For each job i:
        Option 1: skip it
            dp[i-1]

        Option 2: take it
            profit[i] + dp[lastNonOverlappingJob]

dp[i] = max(dp[i - 1], profit[i] + dp[j])
    • job index = i
    • dp index = i
    • previous job = j

🔍 How to find last non-overlapping job?  👉 Binary search on endTime
    Find:
        largest j < i such that end[j] <= start[i]
        
Binary Search Rule (VERY IMPORTANT)
    Whenever write: while (left <= right) OR while (left < right), MUST ensure: Every iteration shrinks the search space

start        1,  2,  3,  3
end          3,  4,  5,  6
profit       50, 10, 40, 70


        1   2   3   4   5   6
1 50    _________
2 10        _________
3 40            _________
4 70            _____________
     
        0   1   2   3   4
  dp    0   50      

*/