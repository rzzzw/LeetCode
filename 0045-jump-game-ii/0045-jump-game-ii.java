class Solution {
    public int jump(int[] nums) {
        int res = 0; 
        int n = nums.length;
        int curEnd = 0;
        int farest = 0;
        for (int i = 0; i < n - 1; i++) {
            farest = Math.max(farest, nums[i] + i);
            if (i == curEnd) {
                res++;
                curEnd = farest;
            }
        }
        return res;
    }
}

/**
                                i
idx     0       1       2       3       4
nums    1       2       1       1       1
                                    curEnd
                                    farest

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

Greedy with window expansion

“At each jump, I want to maximize how far I can reach in the next jump.”
 */

 class Solution {

 }