class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[]{};
        }

        // int[] res = new int[nums.length - (k - 1)];
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // delete all previous smaller/equal values
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // delete the first largest value if it is out of left boundary window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // add current idx to deque
            deque.offerLast(i);

            // store max value of each window;
            if (i >= k - 1) {
                list.add(nums[deque.peekFirst()]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}


/**
              i
        0  1  2   3   4  5  6  7
        1  3  -1  -3  5  3  6  7
        --------
              k-1

        First <------------------------>  Last
        1

 */