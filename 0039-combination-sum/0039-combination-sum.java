class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), 0, target, candidates);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> cur, int idx, int remains, int[] candidates) {

        if (remains == 0) {
            res.add(new ArrayList<>(cur));
            return;   
        }  

        if (remains < 0 || idx == candidates.length) {
            return;
        }
        if (candidates[idx] <= remains) {
            cur.add(candidates[idx]);
            helper(res, cur, idx, remains - candidates[idx], candidates);
            cur.remove(cur.size() - 1);
        }

        helper(res, cur, idx + 1, remains, candidates);
    }
}