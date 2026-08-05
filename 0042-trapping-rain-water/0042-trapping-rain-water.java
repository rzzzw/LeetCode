// Solution 2: 2 Pointers
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = 0; 
        int rightMax = 0;
        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }
        return totalWater;
    }
}

// Solution 1: DP:  Find both side max height for each idx
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length == 0) {
//             return 0;
//         }
//         int res = 0;
//         int n = height.length;
//         int[] leftToRightMax = new int[n];
//         int[] rightToLeftMax = new int[n];
//         int leftMax = height[0];
//         int rightMax = height[n - 1];
//         for (int i = 0; i < n; i++) {
//             leftMax = Math.max(height[i], leftMax);
//             leftToRightMax[i] = leftMax;
//         } 
//         for (int i = n - 1; i >= 0; i--) {
//             rightMax = Math.max(rightMax, height[i]);
//             rightToLeftMax[i] = rightMax;
//         }

//         for (int i = 0; i < n; i++) {
//             res += (Math.min(rightToLeftMax[i], leftToRightMax[i]) - height[i]);
//         }
//         return res;
//     }
// }

// Decreasing monotonic stack
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length < 3) {
//             return 0;
//         }
//         int totalWater = 0;
//         Deque<Integer> stack = new ArrayDeque<>();
//         for (int i = 0; i < height.length; i++) {
//             while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                 int valleyIdx = stack.pop();
//                 if (stack.isEmpty()) {
//                     break;
//                 }
//                 int leftWallIdx = stack.peek();
//                 int rightWallIdx = i;
//                 int width = rightWallIdx - leftWallIdx - 1;
//                 int boundedHeight = Math.min(height[leftWallIdx], height[rightWallIdx]) - height[valleyIdx];
//                 totalWater += boundedHeight * width;           
//             }
//             stack.push(i);
//         }
//         return totalWater;
//     }
// }
