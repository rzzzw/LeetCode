// class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length <= 1) {
//             return 0;
//         }
//         int minPrice = Integer.MAX_VALUE;
//         int max = 0;
//         for (int i = 0; i < prices.length; i++) {
//             minPrice = Math.min(minPrice, prices[i]);
//             max = Math.max(max, prices[i] - minPrice);
//         }
//         return max;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < prices.length) {
            if (prices[i] > prices[j]) {
                i = j;
            }
            max = Math.max(max, prices[j] - prices[i]);
            j++;
        }
        return max;
    }
}