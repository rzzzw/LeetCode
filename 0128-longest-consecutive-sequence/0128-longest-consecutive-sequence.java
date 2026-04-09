class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : set) {
            if (!set.contains(n + 1)) {
                int tempRes = 1;
                while (set.contains(n - 1)) {
                    tempRes += 1;
                    n--;
                }
                res = Math.max(res, tempRes);
            }
        }
        return res;
    }
}


/**
Time Complexity:
    Each number added once → O(n)
    Each number visited once in a sequence → O(n)
➡ Total: O(n)

Space Complexity: HashSet stores all elements → O(n)
 */