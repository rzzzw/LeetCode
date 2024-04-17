// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null) {
//             return res;
//         }
//         dfs(nums, 0, res);
//         return res;
//     }

//     private void dfs(int[] nums, int idx, List<List<Integer>> res) {
//         if (idx == nums.length) {
//             List<Integer> list = new ArrayList<>();
//             for (int num : nums) {
//                 list.add(num);
//             }
//             res.add(list);
//             return;
//         }
//         for (int i = idx; i < nums.length; i++) {
//             swap(nums, idx, i);
//             dfs(nums, idx + 1, res);
//             swap(nums, idx, i);
//         }
//     }

//     private void swap(int[] nums, int lo, int hi) {
//         int tmp = nums[lo];
//         nums[lo] = nums[hi];
//         nums[hi] = tmp;
//     }
// }



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        backtrack(cur, res, nums);
        return res;
    }
    
    public void backtrack(List<Integer> cur, List<List<Integer>> res, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int n : nums) {
            if (!cur.contains(n)) {
                cur.add(n);
                backtrack(cur, res, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}