
/**
                       123
            123        213      321
        123  132    213 231   321  312
    
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>(); // A brand new object is created here everytime
            for (int n : nums) {
                list.add(n);
            }
            res.add(new ArrayList<>(list));   //  res.add(list); is correct here
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            dfs(nums, idx + 1, res);
            swap(nums, idx, i);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}