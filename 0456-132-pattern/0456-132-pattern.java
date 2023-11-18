class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int numk = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < numk) return true;
            while (!stack.isEmpty() && nums[i] > stack.peekFirst()) {
                numk = stack.pollFirst();
            }   
            stack.offerFirst(nums[i]);
        }
        return false;
    }
}


/**
           --- 
               ---
       ---
        i   j   k


 */