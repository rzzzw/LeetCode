class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        swap(nums, 0, nums.length - 1 - k);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }


    private void swap (int[] nums, int leftIdx, int rightIdx) {
        while(leftIdx < rightIdx) {
            int temp = nums[leftIdx]; 
            nums[leftIdx] = nums[rightIdx];
            nums[rightIdx] = temp;
            leftIdx++;
            rightIdx--;
        }
    }
// case: nums = [1]; k = 0   
//java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
    // private void swap(int[] nums, int l, int r) {
    //     int mid = l + (r - l) / 2;
    //     while (l <= mid) {
    //         int temp = nums[l];
    //         nums[l] = nums[r];
    //         nums[r] = temp; 
    //         l++;
    //         r--;
    //     }
    // }
}



// // 整体挪动，借助一个size为 k % nums.length 的array
//  class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;
//         int[] head = new int[k];
//         for (int i = 0; i < k; i++) {
//             head[i] = nums[nums.length - k + i];
//         }
//         for (int i = nums.length - 1; i >= k; i--) {
//             nums[i] = nums[i - k];
//         }
//         for (int i = 0; i < k; i++) {
//             nums[i] = head[i];
//         }
//     }
//  }

