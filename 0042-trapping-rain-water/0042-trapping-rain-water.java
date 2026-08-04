// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length == 0) {
//             return 0;
//         }        
//         int left = 0, right = height.length - 1;
//         int leftMax = 0;
//         int rightMax = 0;
//         int water = 0;

//         while (left < right) {
//             if (height[left] < height[right]) {
//                 leftMax = Math.max(leftMax, height[left]);
//                 water += leftMax - height[left];
//                 left++;
//             } else {
//                 rightMax = Math.max(rightMax, height[right]);
//                 water += rightMax - height[right];
//                 right--;
//             }
//         }
//         return water;
//     }
// }



class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int n = height.length;
        int[] leftToRightMax = new int[n];
        int[] rightToLeftMax = new int[n];
        int leftMax = height[0];
        int rightMax = height[n - 1];
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(height[i], leftMax);
            leftToRightMax[i] = leftMax;
        } 
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightToLeftMax[i] = rightMax;
        }

        for (int i = 0; i < n; i++) {
            res += (Math.min(rightToLeftMax[i], leftToRightMax[i]) - height[i]);
        }
        return res;
    }
}