/**
Time complexity: 2^n

                                  _                                                 2^0
                        /                     \
                    add                          not_add                            2^1
               /           \                 /            \ 
            add        not_add            add            not_add                    2^2
         /    \        /     \           /     \         /     \                    
     add    not_add   add   not_add    add   not_add   add     not_add              2^3

                                                                                    2^n

 1 + 2^1 + 2^2 + ... + 2^n = 2 * 2^(n-1) - 1


Space complexity: 2^n * n
    call stack: O(height) -> n
    Lists(res & cur): 2^n * n 

 */


 class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        dfs(nums, idx + 1, cur, res);
        cur.remove(cur.size() - 1);

        dfs(nums, idx + 1, cur, res);
    }
 }
