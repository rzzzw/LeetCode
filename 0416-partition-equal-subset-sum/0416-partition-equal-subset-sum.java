class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}

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
                  "we can pick some numbers from the array to make sum = i"
       This is a boolean knapsack.
    🔹 Step 3: Base case
            dp[0] = true;   (can always make sum 0 by choosing nothing.)
    🔹 Step 4: Transition (THIS IS CRITICAL)
       For each number num:
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }

        🚨 Focus on ONE line:
            dp[i] = dp[i] || dp[i - num];
        This means:
            To make sum i, we have 2 choices:
            1️⃣ Don’t use num
                • If dp[i] was already true → keep it true
            2️⃣ Use num
                • If we could previously make i - num, then:
                    • add num
                    • now we can make i
            👉 That’s why: dp[i] = dp[i] || dp[i - num];

Example:
        nums = [1, 5, 11, 5]
        target = 11
        dp = [true, false, false, ..., false]
        index: 0     1      2           11

        Step 1: num = 1
        for (i = 11 → 1)
        dp[1] = dp[1] || dp[0] => true
        dp: [T, T, F, F, ..., F]
        👉 We can make sum 1

        Step 2: num = 5
        for (j = 11 → 5)
        dp[6] = dp[6] || dp[1] → true   (1 + 5)
        dp[5] = dp[5] || dp[0] → true   (5)

        dp: [T, T, F, F, F, T, T, ...]
                            ↑  ↑
                            5  6

        🚨 Now the IMPORTANT PART: Why backward?
            ❌ What goes wrong if we go forward?
            If we do:  for (i = num; i <= target; i++)  Let’s see what happens with num = 1:
            Forward update:
                i = 1 → dp[1] = dp[0] = true
                i = 2 → dp[2] = dp[1] = true  ❌
                i = 3 → dp[3] = dp[2] = true  ❌

                👉 You just used 1 multiple times
                👉 That’s WRONG because each number can only be used once

            ✅ Why backward works
            When going backward:   for (i = target; i >= num; i--)

                👉 dp[i - num] is always from the previous state
                👉 So each num is only used once   

            🧠 Intuition (very important)
                Think of it like:
                For each number, we "add it" to previously achievable sums

                Backward ensures:
                • You only use results from the previous round
                • Not results you just updated

    ✅ Time: O(n × target)
    ✅ Space: O(target)

 */

/**
Approach 1: brute force (Time Limit Exceeded)
Time complexity: O(2^n)
Space: O(height) -> O(n)
 */
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

/**
Approach 2: Recursion with Memoization
Time complexity: O(mn)
Space: O(mn)
 */
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         if (sum % 2 != 0) {
//             return false;
//         }

//         sum /= 2;

//         Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];
//         return recursion(nums, memo, 0, sum);
//     }

//     private boolean recursion(int[] nums, Boolean[][] memo, int idx, int sum) {
//         if (sum == 0) {
//             return true;
//         }
//         if (sum < 0 || idx == nums.length) {
//             return false;
//         }

//         if (memo[idx][sum] != null) {
//             return memo[idx][sum];
//         }

//         boolean res = recursion(nums, memo, idx + 1, sum - nums[idx]) || recursion(nums, memo, idx + 1, sum);
//         memo[idx][sum] = res;
//         return res;
//     }
// }

/**
nums = [1, 2, 3, 4]      target = 5

画图
Vertical -> Each level of the tree: add each num or not
Horizotal -> remain sum

nums
:                                           5
                             /                            \
+1?                         5                              4
                    /             \                  /             \ 
+2?                5               3               4                2
               /       \        /      \       /       \         /      \
+3?          5          2      3        0     4         1       2        -1
           /  \       /  \    /  \     / \   /  \      /  \    /  \     /   \  
+4?       5    1     2   -2                  4   0    1   -3  2   -2
                     ------                                   ------
                    same sub problem                         same sub problem

There are same sub problems. To improve the efficiency, use a memo.

memo:
            sum: 0 1 2 3 4 5
nums idx
: 
 0    
 1
 2
 3
 4


 */
