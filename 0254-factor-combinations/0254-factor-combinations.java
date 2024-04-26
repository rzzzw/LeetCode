class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        List<Integer> factors = allFactors(n);
        List<Integer> cur = new ArrayList<>();
        helper(cur, 0, factors, n, res);
        return res;        
    }
    
    private void helper(List<Integer> cur, int idx, List<Integer> factors, int target, List<List<Integer>> res) {
        if (idx == factors.size()) {
            if (target == 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        
        helper(cur, idx + 1, factors, target, res);
        
        int factor = factors.get(idx);
        int size = cur.size();
        while (target % factor == 0) {
            cur.add(factor);
            target /= factor;
            helper(cur, idx + 1, factors, target, res);
        }
        cur.subList(size, cur.size()).clear();    
    }
    
    private List<Integer> allFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}