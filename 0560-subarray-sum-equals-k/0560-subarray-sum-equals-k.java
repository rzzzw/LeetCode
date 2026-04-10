
/**
prefixSum[j] - k = prefixSum[i] => SUM(i+1 ... j) == k


[1,2,3] 3

{0, -1} {1, 0} {3, 1} {6, 2}
                3-3=0  6-3=3


 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            } 
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
           
        }
        return count;
    }
}



/**

Time: O(n)
Space: O(n) (HashMap for prefix sums)
 */

