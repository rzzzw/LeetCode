/**
For each house i, you have 2 choices:
Rob house i → you cannot rob house i–1
Skip house i → you can take the best up to house i–1

So for every index:
dp[i] = max(dp[i-1], dp[i-2] + nums[i])
             cur       pre

compresses DP into 2 variables, because dp[i] only depends on the previous two states.

pre = dp[i-2]
cur = dp[i-1]
 */

// class Solution{
//     public int rob(int[] nums) {
//         int curMax = 0; // dp[i - 1]
//         int preMax = 0; // dp[i - 2]
//         for (int num : nums) {

//             int robThis = num + preMax; // rob house i --> can't rob house i-1, so baseline is the dp[i-2]
//             preMax = curMax; // slide the window foward, dp[i-1] becomes dp[i-2] for the next iteration 
//             curMax = Math.max(robThis, curMax); // Best up to current house = rob it OR skip it
//         }
//         return curMax;
//     }
// }


/**

example:
nums_idx    0   1   2   3
nums        1   2   3   1
s           1   2   4   3
ns          0   1   2   4
max         1   2   4   4

idx     0   1   2   3   4
dp      0   1   2   4   4


example 2:
nums_idx    0   1   2   3
nums        2   1   1   2
s           2   1   3   4
ns          0   2   2   3
max         2   2   3   4

idx     0   1   2   3   4
dp      0   2   2   3   4

 */

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];  // 1～n 代表第n个房子， dp[0]代表还没开始偷

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);// 注意nums[i - 1]！ dp[] off by 1, 所以读取对应房子财产的时候要 减1
        }
        return dp[n];
    }
}