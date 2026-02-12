class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = right * res[i];
            right *= nums[i]; 
        }
        return res;
    }
}

/**

product_except_i = (product of all elements to the LEFT of i) × (product of all elements to the RIGHT of i)

                0  1  2  3
        nums = [1, 2, 3, 4]
        left    1  1  2  6
        right  24 12  4  1

    res[i] = left[i] * right[i]
    res = [24, 12, 8, 6]

 */

