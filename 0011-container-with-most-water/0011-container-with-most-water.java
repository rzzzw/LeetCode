class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int cur = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, cur);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}