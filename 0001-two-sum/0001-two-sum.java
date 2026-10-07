class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

/**
The brute-force solution compares every pair, so it performs repeated scans of the array, resulting in O(n²) time.

To avoid that repeated work, I'll trade space for time by maintaining a HashMap from value to index.

As I iterate the array, I compute the complement target - nums[i].

If that complement already exists in the map, I've found the answer because the map only contains previously visited elements.

Otherwise, I insert the current value and index into the map and continue.

Each element is inserted into the map at most once and looked up at most once.O(1)


Challenge from interviewer:
• HashMap lookup isn't always O(1).
• Answer: Strictly speaking, HashMap lookup is O(1) on average assuming a good hash function and controlled load factor. In the pathological case with many collisions it could degrade, but in interview complexity analysis we generally use the average-case complexity.
 */

