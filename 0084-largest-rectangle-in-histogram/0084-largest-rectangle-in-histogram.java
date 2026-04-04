/**
Key Insight: 
For each bar i: What is the widest rectangle where heights[i] is the minimum height?

For every index, find the previous smaller element and the next smaller element. 👉 Monotonic Stack

width = rightSmallerIndex - leftSmallerIndex - 1
area  = heights[i] × width

Time complexity: O(n)
Space complexity: O(n)
*/

/* 
Monotonic Increasing Stack
Stack stores indices, maintain: increasing heights

When do we calculate area? 
• When we see a smaller height. That means:
    The previous bar can’t extend further
**/
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int curHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; //.pollFirst()

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i); // .offerFirst()
        }
        return maxArea;
    }
}








