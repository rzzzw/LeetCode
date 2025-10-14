class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helper(new ArrayList<>(), 0, res, candidates, target);
        return res;
    }
    private void helper(List<Integer> cur, int idx, List<List<Integer>> res, int[] candidates, int remains) {

        if (remains == 0) {
            res.add(new ArrayList<>(cur));
            return;   
        }  

        if (remains < 0) {
            return;
        }


        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);                
            helper(cur, i, res, candidates, remains - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}