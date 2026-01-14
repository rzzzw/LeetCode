class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0; 
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) { // Minimum is in the right half
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
/** 
Identify which half is sorted. 

Key observation (critical)：

    At any point:
        If nums[mid] > nums[right]
        → Minimum is to the right of mid

    Else
        → Minimum is at mid or to the left

    Why?
        The rotation break causes the drop
        The right side always contains the smallest element when unsorted

*/
