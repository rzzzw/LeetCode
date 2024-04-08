class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> cur = new ArrayList<>();
        helper(nums, 0, cur, res);
        return res;
    }
    
    private void helper(int[] nums, int idx, List<Integer> curList, List<List<Integer>> res) {  
        if (idx == nums.length) {
            res.add(new ArrayList<>(curList));
            return;
        }
        
        curList.add(nums[idx]);
        helper(nums, idx + 1, curList, res);
        curList.remove(curList.size() - 1);
        
        helper(nums, idx + 1, curList, res);
    }
}

/*
Recursion Tree
									                     [		]
size = 0  solution
								                    /		\		   \
 level 1:                                        1			  2		      3
size = 1  solution
									          /	  \ 	    	\
	level 2:						       1,2	 1,3	        2,3
size = 2  solution		
								          /
	level3:						      1,2,3
size = 3  solution					                     


[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]

Time: O(2^n)

*/

//// Add or not add:
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null || nums.length == 0) {
//             return res;
//         }
//         backTracking(nums, 0, new ArrayList<Integer>(), res);
//         return res;
//     }
    
//     private void backTracking(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
//         if (idx == nums.length) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }
//         cur.add(nums[idx]);
//         backTracking(nums, idx+1, cur, res);
//         cur.remove(cur.size() - 1);
        
//         backTracking(nums, idx+1, cur, res);
//     }
// }


// /**
// Time complexity: 2^n

//                                   _                                                 2^0
//                         /                     \
//                     add                          not_add                            2^1
//                /           \                 /            \ 
//             add        not_add            add            not_add                    2^2
//          /    \        /     \           /     \         /     \                    
//      add    not_add   add   not_add    add   not_add   add     not_add              2^3

//                                                                                     2^n

//  2^0 + 2^1 + 2^2 + ... + 2^n = 2 * 2^(n-1) - 1


// Space complexity: 2^n * n
//     call stack: O(height) -> n
//     Lists(res & cur): 2^n * n 

//  */
