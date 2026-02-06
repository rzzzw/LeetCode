/**
Key Insight: 
For each bar i: What is the widest rectangle where heights[i] is the minimum height?

For every index, find the previous smaller element and the next smaller element. 👉 Monotonic Stack

width = rightSmallerIndex - leftSmallerIndex - 1
area  = heights[i] × width


*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++){
            int curHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pollFirst()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;

                maxArea = Math.max(maxArea, width * height);
            } 
            stack.offerFirst(i);
        }
        return maxArea;

    }
}




