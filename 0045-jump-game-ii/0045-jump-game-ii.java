// Greedy

class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int curEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {  // note: don't need to jump from last index. (Iteration stops once reached the last index)
            farthest = Math.max(farthest, i + nums[i]);

            if (i == curEnd) {
                steps++;
                curEnd = farthest;
            }
        }
        return steps;
        
    }
}



/**
DP idea (Killed)
nums = [2,3,1,1,4]
dp   : [0,max,max,max,max]

DP status: dp[i] = minimum jumps to reach index i

DP Transition: dp[j] = min(dp[j], dp[i] + 1) for all j in [i+1, i+nums[i]]
From index i, one jump lets me reach every index 'j' in its jump range, so for each such index j, I try to minimize its jump count by updating dp[j] = dp[i] + 1.

Time: O(n²) ❌ Expensive!


⭐ Greedy insight ⭐
- From all indices reachable with current jump, choose the one that lets you reach farthest next
This becomes a sliding window problem.

Core idea:
- currentEnd = farthest index reachable with current jump
- farthest = farthest index reachable from all visited indices
- When you reach currentEnd, you must jump


                                        i
idx     0       1       2       3       4
nums    1       2       1       1       1
                                       curEnd
                                       farthest

res = 3; 

对比这题 https://app.laicode.io/app/problem/89
code is not applicable for this case in Laicode 89

                                i             iterate 0 ~ 3
idx     0       1       2       3       4
nums    1       2       1       0       1
                            curEnd
                            farest

res = 3; 

What's the difference? is it because "The test cases are generated such that you can reach nums[n - 1]." ??


 */

