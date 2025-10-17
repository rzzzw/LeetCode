class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int remain, int idx) {
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (remain < 0) {
            return;
        }

        if (idx == candidates.length) {
            return;
        }

        
        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, cur, candidates, remain - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}


// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (candidates == null || candidates.length == 0) {
//             return res;
//         }
//         helper(res, new ArrayList<>(), candidates, target, 0);
//         return res;
//     }
//     private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int remains, int idx) {
//         if (remains == 0) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }

//         if (idx == candidates.length) return;
//         int val = candidates[idx];
//         int maxCount = remains / val;

//         for (int count = 0; count <= maxCount; count++) {
//             helper(res, cur, candidates, remains - count * val, idx + 1);
//             cur.add(val);
//         }

//         for (int k = 0; k < maxCount; k++) {
//             cur.remove(cur.size() -1);
//         }
//     }
// }






/**
[2 3 5]  8

                    2                        3                    5
        2 2         2 3      2 5         3 3       3 5(r)         5  5(r)

222   223  225(r)   233(r) 235(r)  255(r)        333(r)   335(r)         
2222(r)2223(r)2233(r)     

 */