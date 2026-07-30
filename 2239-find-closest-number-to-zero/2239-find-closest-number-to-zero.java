class Solution {
    public int findClosestNumber(int[] nums) {
        int minA = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int n : nums) {
            int nA = n;
            if (nA < 0) {
                nA *= -1;
            }
            if (nA < minA) {
                minA = nA;
                res = n;
            } else if(nA == minA && n > res) {
                res = n;
            }
        }
        return res;
    }
}

