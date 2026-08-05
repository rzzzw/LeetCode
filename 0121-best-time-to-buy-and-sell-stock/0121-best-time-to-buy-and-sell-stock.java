class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int max = 0;        
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }
}

