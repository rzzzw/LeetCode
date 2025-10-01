
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int globalMax = 0;
        while(l < r) {
            int minHeight= Math.min(height[l], height[r]);
            int curArea = minHeight * (r - l);
            globalMax = Math.max(globalMax, curArea);
            while (l != r && height[l] <= minHeight) {
                l++;
            }
            while (l != r && height[r] <= minHeight) {
                r--;
            }
        }
        return globalMax;
    }
}