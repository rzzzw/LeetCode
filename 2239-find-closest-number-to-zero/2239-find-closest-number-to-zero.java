class Solution {
    public int findClosestNumber(int[] nums) {
        int resAb = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for (int n : nums) {
            if (Math.abs(n) <= Math.abs(res)) {
                res = n;
                if (n > 0) {
                    resAb = n;
                }
            }
        }
        if (Math.abs(res) == Math.abs(resAb)) {
            return Math.max(res, resAb);
        }
        return res;
    }
}