/**
        0 1 2 3 4
nums = [1,1,1,1,1], target = 3

                         (idx=0,sum=0)
                         /           \
                       +1             -1
                      /                 \
               (1, 1)                  (1,-1)
                /   \                    /   \
              +1    -1                 +1    -1
              ↓      ↓                  ↓      ↓
           (2,2)   (2,0)             (2,0)   (2,-2)
                     ↑                  ↑
                     SAME STATE!

(idx=2,sum=0) From this point onward, the remaining problem is identical. That's the signal for DP.
The state is:
(idx, sum)

because if I know:
1. which number I'm currently processing, and
2. my current sum,

I have everything necessary to determine how many valid assignments remain.

How many ways can I reach the target from this state?
dfs(idx, sum) = number of ways to reach target using nums[idx ... n-1] given my current sum

dfs(idx, sum) = dfs(idx + 1, sum + nums[idx]) + dfs(idx + 1, sum - nums[idx])

Complexity: 
Let S = sum of all nums. Possible sums range approximately from: -S ... 0 ... +S. So there are at most: 2S + 1 different sums.
And there are n possible indices. Therefore the number of unique states is: n × (2S + 1)

There are n possible index levels, and at each level there are at most 2S + 1 possible current sums. Therefore there are O(nS) unique (idx, sum) states.

Time:  O(nS)  
Space: O(nS)
 */

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<String, Integer> memo = new HashMap<>();
//         return dfs(nums, target, 0, 0, memo);
//     }

//     private int dfs(int[] nums, int target, int idx, int sum, Map<String, Integer> memo) {
//         if (idx == nums.length) {
//             return sum == target ? 1 : 0;
//         }

//         String key = idx + "," + sum;

//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         int add = dfs(nums, target, idx + 1, sum + nums[idx], memo);
//         int subtract = dfs(nums, target, idx + 1, sum - nums[idx], memo);

//         int ways = add + subtract;
//         memo.put(key, ways);

//         return ways;
//     }
// }


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }
        if ((totalSum + target) % 2 != 0) {
            return 0;
        }
        int subsetSum = (totalSum + target) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int s = subsetSum; s >= n; s--) {
                dp[s] += dp[s - n];
            }
        }

        return dp[subsetSum];

    }
}


// DFS/backtracking O(2^n) <- every number gives you two choices, + or -.
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int[] count = new int[]{0};
//         helper(nums, target, 0, 0, count);
//         return count[0];
//     }
//     private void helper(int[] nums, int target, int idx, int sum, int[] count){
//         if (idx == nums.length) {
//             if (sum == target) {
//                 count[0]++;
//             }
//             return;
//         }

//         // "+"
//         // sum += nums[idx];
//         // helper(nums, target, idx + 1, sum, count);
//         // sum -= nums[idx];
//         helper(nums, target, idx + 1, sum + nums[idx], count);

//         // "-"
//         // sum += nums[idx] * (-1);
//         // helper(nums, target, idx + 1, sum, count);
//         helper(nums, target, idx + 1, sum - nums[idx], count);
//     }

// }