class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1; 
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return - 1;
    }
}

// [1, 2] target: 1
// [1, 2] target: 2
// [2, 1] target: 1

/**
ascending + left rotated:
• 比mid小的数不一定在mid左边
• 比mid大的数若存在一定在mid右边
因此binary search砍半的时候，
    */ 