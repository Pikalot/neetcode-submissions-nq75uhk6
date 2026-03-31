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
