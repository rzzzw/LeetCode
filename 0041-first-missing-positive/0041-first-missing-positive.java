class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}


/**
For an array of length n:  The answer must be in the range [1, n+1]. 
    - If 1..n are all present → answer is n+1
    - Otherwise, the missing one is inside 1..n

So only care about numbers in: 1 ≤ x ≤ n, Everything else is noise.

idx:    0 1 2 3 
value:  1 2 3 4
nums[i] == i + 1        =>    i = nums[i] - 1

For index i, value x = nums[i]: 
Correct index for x is: x - 1 
                       --------  nums[i] - 1
            ==> nums[nums[i] - 1] = nums[i];

So while:
    nums[i] > 0 &&
    nums[i] <= n &&
    nums[nums[i] - 1] != nums[i]

Swap:
    swap(nums, i, nums[i] - 1)


Dry run:

        0  1  2   3
        3, 4, -1, 1

    i = 0 → 3 → should be at index 2
    swap → [-1,4,3,1]

 */