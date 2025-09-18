class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = Factors(n);
        helper(n, 0, factors, cur, res);
        return res;
    }
    private void helper(int remain, int idx, List<Integer> factors, List<Integer> cur, List<List<Integer>> res) {
        if (idx == factors.size()) {
            if (remain == 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(remain, idx + 1, factors, cur, res);
        int factor = factors.get(idx);
        int count = 0;
        while(remain % factor == 0) {
            cur.add(factor);
            count++;
            remain /= factor; // 这句不能省
            helper(remain, idx + 1, factors, cur, res); // 如果写成 helper(remain / factor, idx + 1, factors, cur, res), Memory Limit Exceeded, 因为remain 的value 没有迭代
        }
        for (int i = 0; i < count; i++){
            cur.remove(cur.size() - 1);
        }
    }
    private List<Integer> Factors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                factors.add(i);
            } 
        }
        // for (int i = n / 2; i > 1; i--) {
        //     if (n % i == 0 ) {
        //         factors.add(i);
        //     }
        // }
        return factors;
    }
}


