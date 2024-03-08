class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        return null;
    } 
}

/*
target = 9

 i:      0 1 2  3
num[i]:  2 7 11 15
 x:      7 2

map: {{2, 0}}
*/
