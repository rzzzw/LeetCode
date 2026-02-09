/**
Step 1: Find the pivot
    Scan from right to left, find the first index i such that:
        nums[i] < nums[i + 1]

Step 2: Find the successor
    From the right, find the first number greater than nums[i], say at index j.
    Because the suffix is descending, this is the smallest number larger than the pivot.

Step 3: Swap + Reverse
    Swap nums[i] and nums[j]
    Reverse the suffix nums[i+1 ... end] to get the smallest order
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Step 1: find pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: find successor
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse suffix
        reverse(nums, i + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }    
}