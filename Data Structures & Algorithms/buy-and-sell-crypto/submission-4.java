// prices   10  1   5   6   7   1
//              b
//                              s
// profit 0      |   max 6

// prices   10  2   5   1   7   8
//                      b 
//                              s
// profit 7      |   max 7

class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) return 0;
        int maxProfit = 0;
        int minBuy = prices[0];

        for (int i = 0; i < length; i++) {
            if (minBuy > prices[i]) minBuy = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }

        return maxProfit;
    }
}
