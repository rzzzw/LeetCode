// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] res = new int[n];

//         res[0] = 1;
//         for (int i = 1; i < n; i++) {
//             res[i] = nums[i - 1] * res[i - 1];
//         }
//         int right = 1;
//         for (int i = n - 1; i >= 0; i--) {
//             res[i] = right * res[i];
//             right *= nums[i];
//         }
//         return res;
//     }
// }


/**
After the left pass, each element in that array holds the product of all previous elements. After the right pass, each element holds the product of all following elements.

product_except_i = (product of all elements to the LEFT of i) × (product of all elements to the RIGHT of i)

                0  1  2  3
        nums = [1, 2, 3, 4]
        left    1  1  2  6      <= directly fill in res temperally 
        right  24 12  4  1

    res[i] = left[i] * right[i]
    res = [24, 12, 8, 6]

 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        } 
        int a = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            a *= nums[i + 1];
            res[i] *= a;
        }
        return res;
    }
}
