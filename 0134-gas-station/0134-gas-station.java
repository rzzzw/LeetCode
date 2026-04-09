class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int curSum = 0; 
        int res = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];

            if (curSum < 0) {
                curSum = 0;
                res = i + 1; 
            }
        }
        return totalSum >= 0 ? res : -1;
    }
}