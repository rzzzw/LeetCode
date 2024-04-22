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
            List<Integer> cur = new ArrayList<>();
            for (int n : nums) {
                cur.add(n);
            }
            res.add(cur);
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

/*
                                                                      origin: 123
                                               /                             |                           \                    => for the layer0: elements to be swapped to idx 0 can be: idx 0, 1, 2
Level0                                     1][23                           2][13                        3][21        
swap elements with idx 0                 swap 0,0                         swap 1,0                     swap 2,0                            [layer0 end: elements before idx 1 are all fixed]
                                       /           \                      /           \                /           \
                                      /             \                    /             \              /             \            => for the layer1: elements to be swapped to idx 1 can be: idx 1, 2
Level1                            12][3           13][2              21][3            23][1          32][1         31][2                                                       
swap elements with idx 1        swap 1,1         swap 2,1         swap 1,1          swap 2,1        swap 1,1        swap 2,1                  [layer1 end: elements before idx 2 are all fixed]
                                    |                |                 |                 |            |               |
                                    |                |                 |                 |            |               |          => for the layer3: elements to be swapped to idx 2 can be: idx 2
                                  123               132               213               231          321             312
                                swap 2,2         swap 2,2         swap 2,2          swap 2,2        swap 2,2         swap 2,2
            


*/


// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null || nums.length == 0) {
//             return res;
//         }
//         List<Integer> cur = new ArrayList<>();
//         backtrack(cur, res, nums);
//         return res;
//     }
    
//     private void backtrack(List<Integer> cur, List<List<Integer>> res, int[] nums) {
//         if (cur.size() == nums.length) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }
        
//         for (int n : nums) {
//             if (!cur.contains(n)) {  // o(n)
//                 cur.add(n);
//                 backtrack(cur, res, nums);
//                 cur.remove(cur.size() - 1);
//             }
//         }
//     }
// }


/* [1, 2, 3] 
    n

cur:[2,1,3]
res:[1,2,3] [1,3,2]


                                                            ___
                                /                             |                           \
                            1                               2                           3                               
                    /        |       \
                 1 1(x)     1 2      1 3                                                                                
                         /   |   \
                    121(x) 122(x) 123

*/ 