class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0; 
        int right = nums.length - 1;
        int i = n - 1;

        while (left <= right) {
            int absLarger = 0;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                absLarger = left;
                left++;
            } else {
                absLarger = right;
                right--;
            }
            res[i] = nums[absLarger] * nums[absLarger];
            i--;
        }
        return res;
    }
}



