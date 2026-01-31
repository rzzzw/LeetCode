class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         int[] sum = new int[nums.length + 1];       // + 1!!
//         sum[0] = 0;
//         for (int i = 1; i < sum.length; i++) {
//             sum[i] = sum[i - 1] + nums[i - 1];      // prefix sum, understand why off by one for this problem!
//         }
//         for (int start = 0; start < nums.length; start++) {
//             for (int end = start + 1; end <= nums.length; end++){
//                 if (sum[end] - sum[start] == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

/**
case 1:     [1]     0

idx:        0
nums:       1               nums.length = 1
sum:        0  1
start:     |_|              [0, 1)
end:          |_|           [1, 1]


case 2:     [-1,-1,1] 0

idx:        0   1   2
nums:       -1  -1  1               nums.length = 3
sum:        0   -1  -2  -1
start:     |_|                      [0, 3)
end:           |_|                  [1,3]
                 

 */

