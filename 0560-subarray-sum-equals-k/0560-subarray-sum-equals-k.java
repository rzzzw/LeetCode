
/**
If a subarray (j+1 ... i) sums to k.  ==>  prefix[i] - prefix[j] = k 
=> prefix[j] = prefix[i] - k

At index i, I want to know: How many previous prefix sums equal to sum - k? <=> “At each position, how many previous sums can pair with me to form k?”

🚀 Algorithm
1. Keep running sum sum
2. Use hashmap:
    • key = prefix sum
    • value = count of occurrences
3. At each index:
    • check how many times (sum - k) appeared before


Why map.put(0, 1)? 👉 Handles subarrays starting from index 0
e.g. nums = [2], k = 2
    sum = 2
    sum - k = 0 → found in map

⚠️ Important Difference from LC525
    Problem	    Goal	            Map stores
    525	        longest length	    first index
    560	        count subarrays	    frequency


Example Walkthrough:  
1. nums = [1,1,1], k = 2
    Step-by-step
    i    num	sum     sum-k	count
    0    1	    1	    -1  	0
    1    1	    2	    0	    +1
    2    1	    3	    1	    +1
    Answer = 2


2. nums = [1,-2,3,-1, 1], k = 1
    Step-by-step
    i    num	sum(k)   sum-k	    count     (v)
                0                    0         1
    0    1      1        0           +1=1      1
    1    -2     -1       -2          1         1
    2    3      2        1           +1=2      1
    3    -1     1        0           +1=3      update to 2
    4    1      2        1           +2=5      update to 2
    Answer = 5

 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int count = 0;
        for (int n : nums) {
            prefix += n;
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }  
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}




/**
Time: O(n)
Space: O(n) (HashMap for prefix sums)

 */

