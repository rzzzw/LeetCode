/**
Core insight:
Need a structure that:
    - Keeps elements in descending order
    - Removes elements that fall out of the window
    - Always exposes the maximum in O(1)
👉 Monotonic Decreasing Deque (store indices, not values)

Core pattern:
    - Sliding Window
    - Monotonic Queue(Queue)

Why indices instead of values? Because we must:
    - Know when an element leaves the window
    - Compare positions with i - k

Brute force? - O(nk) → too slow ❌ 
Heap approach - O(n log k)
Optimal idea: Monotonic Deque
    Maintain a deque where:
        - Values are strictly decreasing
        - Front always holds index of max element

Deque invariants (VERY IMPORTANT)
    - Indices are in increasing order
    - Values are in decreasing order
    - Front is always the maximum of the window

example:
              i
1,3,-1,-3,5,3,6,7

deque:  6
res:    3 3 5 5 6

*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {

            // 1. remove indices out of window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst(); 
            }

            // 2. Maintain decreasing order
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Record max when window is formed
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;


    }
}


