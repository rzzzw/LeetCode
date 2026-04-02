class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] events = new int[n][3];
        for (int i = 0; i < n; i++) {
            events[i][0] = startTime[i];
            events[i][1] = endTime[i];
            events[i][2] = profit[i];
        }
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // Sort by end time
        
        int[] dp = new int[n + 1]; // dp[i] = the maximum value can get at in previous i events
        
        for (int i = 1; i <= n; i++) {
            int prevNonOverlappingEvent = searchEvent(events, events[i - 1][0]) - 1; // WIF target startTime = 3 (events[2][0]) => prevNonOverlappingEvent = 0
            dp[i] = Math.max(dp[i - 1], dp[prevNonOverlappingEvent + 1] + events[i - 1][2]); // dp[] idx off by 1
        }
        return dp[n];
    }
    
    // private int searchEvent(int[][] arr, int target) { // find the first event with endingPoint > the target startTime
    //     int left = 0;
    //     int right = arr.length - 1;
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         if (arr[mid][1] <= target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }
    //     return left;
    // }
    private int searchEvent(int[][] arr, int target) {
        int left = 0, right = arr.length - 1;
        int res = arr.length; // default: no such index

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid][1] > target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}

// idx          0   1   2   3
// start        1,  2,  3,  3
// end          3,  4,  5,  6
// profit       50, 10, 40, 70


// class Solution {
//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//         int n = startTime.length;

//         int[][] jobs = new int[n][3];
//         for (int i = 0; i < n; i++) {
//             jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
//         }

//         // Sort by end time
//         Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

//         int[] dp = new int[n];
//         dp[0] = jobs[0][2];

//         for (int i = 1; i < n; i++) {
//             int currProfit = jobs[i][2];

//             // Find last non-overlapping job
//             int j = binarySearch(jobs, i);

//             if (j != -1) {
//                 currProfit += dp[j];
//             }

//             dp[i] = Math.max(dp[i - 1], currProfit);
//         }

//         return dp[n - 1];
//     }

//     private int binarySearch(int[][] jobs, int i) {
//         int left = 0, right = i - 1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (jobs[mid][1] <= jobs[i][0]) {
//                 if (mid + 1 <= right && jobs[mid + 1][1] <= jobs[i][0]) {
//                     left = mid + 1;
//                 } else {
//                     return mid;
//                 }
//             } else {
//                 right = mid - 1;
//             }
//         }

//         return -1;
//     }
// }
    

/*
Step 2️⃣: DP definition
        dp[i] = max profit using jobs[0...i]

Step 3️⃣: Transition
    For each job i:
        Option 1: skip it
            dp[i-1]

        Option 2: take it
            profit[i] + dp[lastNonOverlappingJob]

🔍 How to find last non-overlapping job?  👉 Binary search on endTime
    Find:
        largest j < i such that end[j] <= start[i]
        


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