

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         if (sum % 2 != 0) {
//             return false;
//         }
//         int target = sum / 2;
//         boolean[] dp = new boolean[target + 1]; 
//         dp[0] = true;
//         for (int num : nums) {
//             for (int i = target; i >= num; i--) {
//                 dp[i] = dp[i] || dp[i - num];
//             }
//         }
//         return dp[target];
//     }
// }

/**
1. Problem Understanding

   - Restate in simple words

   - Key observation (think aloud)

    If total sum is S:
        - We need to find one subset with sum S / 2
        - The other subset automatically has sum S / 2
    
    Immediate pruning (Important!!) - If total sum is odd → impossible

2. Interview Strategy
    - Core pattern =>  ✅ 0/1 Knapsack (subset sum)
        Each number:
          - either chosen   
          - or not chosen
          - used at most once

3. Step-by-Step Solution Development
    🔹 Step 1: Target sum
    🔹 Step 2: DP state
            dp[i] = true
            means: it is possible to reach sum i using some subset
       This is a boolean knapsack.
    🔹 Step 3: Base case
            dp[0] = true;   (can always make sum 0 by choosing nothing.)
    🔹 Step 4: Transition (THIS IS CRITICAL)
       For each number num:
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }


    ✅ Time: O(n × target)
    ✅ Space: O(target)

Example:
        nums = [1, 2, 3]
        target = 3
        dp[0] = true

        num = 1
        i = 3 -> i = 1
        dp[1] = dp[1] || dp[0] => true

        num = 2
        i = 3 -> i = 2
        dp[3] = dp[3] || dp[3 - 2]
        dp[2] = dp[2] || dp[2 - 2]

        num = 3
        i = 3
        dp[3] = dp[3] || dp[3 - 3]



 */

// // brute force (Time Limit Exceeded)
// // Time complexity: O(2^n)
// // Space: O(height) -> O(n)
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         if (sum % 2 != 0) {
//             return false;
//         }

//         return recursion(nums, 0, sum / 2);
//     }
//     private boolean recursion(int[] nums, int idx, int sum) {
//         if (sum == 0) {
//            return true; 
//         } 
//         if (sum < 0 || idx == nums.length) {
//             return false;
//         }
//         return recursion(nums, idx + 1, sum - nums[idx]) || recursion(nums, idx + 1, sum);
//     }
// }


class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];
        return recursion(nums, memo, 0, sum);
    }

    private boolean recursion(int[] nums, Boolean[][] memo, int idx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || idx == nums.length) {
            return false;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        boolean res = recursion(nums, memo, idx + 1, sum - nums[idx]) || recursion(nums, memo, idx + 1, sum);
        memo[idx][sum] = res;
        return res;
    }
}

/**
nums = [1, 2, 3, 4]
memo:
   sum 0 1 2 3 4 5
num 
 0    
 1
 2
 3
 4


 */