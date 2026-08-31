/**
binary-decision backtracking formulation
 */

// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (candidates == null || candidates.length == 0) {
//             return res;
//         }
//         backtrack(candidates, target, 0, new ArrayList<>(), res);
//         return res;
//     }

//     private void backtrack(int[] candidates, int remains, int idx, List<Integer> cur, List<List<Integer>> res) {
//         if (remains == 0) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }

//         if (remains < 0 || idx == candidates.length) {
//             return;
//         }

//         // 加
//         if (candidates[idx] <= remains) {
//             cur.add(candidates[idx]);
//             backtrack(candidates, remains - candidates[idx], idx, cur, res);  // ❌ idx + 1
//             cur.remove(cur.size() - 1);
//         }

//         // 不加
//         backtrack(candidates, remains, idx + 1, cur, res);
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int idx, int remain, List<Integer> cur, List<List<Integer>> res) {
        if (idx >= candidates.length) {
            if (remain == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        // 加
        if (candidates[idx] <= remain) {
            cur.add(candidates[idx]);
            backtrack(candidates, idx, remain - candidates[idx], cur, res);
            cur.remove(cur.size() - 1);
        }

        backtrack(candidates, idx + 1, remain, cur, res);
    }
}