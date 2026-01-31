class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num + 1)) {
                int tmpRes = 1;
                while (set.contains(num - 1)) {
                    tmpRes++;
                    num--;
                }
                res = Math.max(res, tmpRes);
            }
        }
        return res;
    }
}