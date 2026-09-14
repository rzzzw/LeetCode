/*
We need, for each day, the number of days until we see a warmer temperature.
A brute-force solution would scan forward from every day, which is O(n²).

The key observation is that while scanning from left to right, some previous days are still “waiting” for their first warmer day. We can keep those unresolved days in a stack.

I’ll use a monotonic decreasing stack of indices. The temperatures corresponding to those indices are in decreasing order from bottom to top.

For each current day i, if temperatures[i] is warmer than the temperature at the index on top of the stack, then the current day is the first warmer day for that previous index. So I pop that index j and set:
        answer[j] = i - j

I keep popping while the current temperature is warmer than the stack top, because the same current day may resolve multiple previous days.

After that, I push the current index onto the stack because it is now waiting for its own warmer day.

Each index is pushed once and popped at most once, so the time complexity is O(n), and the stack uses O(n) space.
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}

/**
Monotonic Stack
 */