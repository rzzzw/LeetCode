class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        helper(nums, 0, cur, res);
        return res;        
    }
    
    private void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(nums[idx]);
        helper(nums, idx + 1, cur, res);
        cur.remove(cur.size() - 1);
        
        while(idx < nums.length - 1 && nums[idx + 1] == nums[idx]) {
            idx++;
        }
        
        helper(nums, idx + 1, cur, res);
    }
}

/*
[a,b,b]


Recursion Tree
									                              [		   ]
            					                   /add				                  \ Not add
Level 1:	                                      [a]                                   [ ]
                                             /           \                           /           \
Level 2:                            [a, b1]               [a]                   [b1]               [ ]
                               /             \         /       \             /       \           /      \
Level 3:                  [a, b1, b2]     [a, b1]  [a, b2]     [a]      [b1, b2]    [b1]      [b2]      [ ]
                                          -------  -------                          ----      ----
                                                  duplicate                                  duplicate
                                                   pruning                                    pruning


[[a, b, b], [a, b], [a], [b, b], [b], []]



*/