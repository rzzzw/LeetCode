// 
// class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length <= 1) {
//             return 0;
//         }
//         int maxProfit = 0;
//         int minPrice = prices[0];
//         for (int i = 0; i < prices.length; i++) {
//             if (prices[i] < minPrice) {
//                 minPrice = prices[i];
//             } else {
//                 maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//             }
//         }
//         return maxProfit;
//     }
// }


/**
int maxProfit = 0;
int minPrice = price[0];
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        }
        return maxProfit;
    }
}