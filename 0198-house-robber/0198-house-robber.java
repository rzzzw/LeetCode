// class Solution {
//     public int rob(int[] nums) {
//         int preMax = 0;
//         int curMax = 0;
//         for (int num : nums) {
//             int tmp = curMax;
//             curMax = Math.max(preMax + num, curMax);
//             preMax = tmp;
//         }
//         return curMax;
//     }
// }

// class Solution {
//     public int rob(int[] nums) {
//         int pre = 0;
//         int cur = 0;
//         for (int num : nums) {
//             int tmp = num + pre; // tmp        -- with the latest idx num
//             pre = cur;           // pre & cur  -- without the latest idx num
//             cur = Math.max(tmp, cur); 
//         }
//         return cur;
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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1]; // 1～n 代表第n个房子， dp[0]代表还没开始偷

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]); // 注意nums[i - 1]！ dp[] off by 1, 所以读取对应房子财产的时候要 减1
        }
        return dp[n];
    }
}

