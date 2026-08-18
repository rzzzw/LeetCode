// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//         List<String> ranges = new ArrayList<>();

//         for (int i = 0; i < nums.length; i++) {
//             int start = nums[i];
//             while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
//                 i++;
//             }

//             if (start != nums[i]) {
//                 ranges.add(start + "->" + nums[i]);
//             } else {
//                 ranges.add(String.valueOf(start));
//             }
//         }

//         return ranges;
//     }
// }


class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res; 
        }
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (r + 1 < nums.length && nums[r] + 1 == nums[r + 1]){
                r++;
            }
            if (r == l) {
                res.add(String.valueOf(nums[l]));
            } else {
                res.add(nums[l] + "->" + nums[r]);
            }
            r++;
            l = r;
        }
        return res;
    }
}