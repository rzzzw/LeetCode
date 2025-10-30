class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }
        return longest;
    }
}

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         List<Integer> sub = new ArrayList<>();
//         sub.add(nums[0]);
//         for (int i = 0; i < nums.length; i++) {
//             int num = nums[i];
//             if (num > sub.get(sub.size() - 1)) {
//                 sub.add(num);
//             } else {
//                 int j = binaryLocate(sub, num);
//                 sub.set(j, num);
//             }
//         }
//         return sub.size();
//     }

//     private int binaryLocate(List<Integer> sub, int num) {
//         int left = 0;
//         int right = sub.size() - 1;
//         while (left < right) {
//             int mid = left + (right - left)/2;
//             int midVal = sub.get(mid);
//             if (midVal == num) {
//                 return mid;
//             } else if (midVal < num) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
//         return left;
//     }
// }