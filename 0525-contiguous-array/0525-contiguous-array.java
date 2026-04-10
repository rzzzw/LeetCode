/**
prefix sum + hashmap

Let: prefixSum[i] = sum from index 0 → i

If: prefixSum[j] == prefixSum[i]
   👉 Then: (i+1 ... j) sum = 0 
   👉 That subarray has equal 0 and 1 ✅

🔑 Strategy
1. Convert:
    • 0 → -1
    • 1 → +1
2. Use hashmap:
    • key = prefix sum
    • value = first occurrence index
3. If same sum appears again:
    • subarray between them = valid

     0  1  2  3  4  5  6  7
     0  1  0  1  0  0  1  1
sum  -1 0  -1 0  -1 -2 -1 0

k : v
0  -1
-1  0
-2  5

 */


class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // k: v => prefix sum : first occurence index
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            } 
        }
        return maxLen;
    }
}