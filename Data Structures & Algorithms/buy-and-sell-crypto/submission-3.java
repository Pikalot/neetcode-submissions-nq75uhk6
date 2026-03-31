class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int profit = 0;
        int s = 0, b = 0;
        while (s < prices.length) {
            if (prices[b] > prices[s]) b = s;
            profit = Math.max(profit, prices[s] - prices[b]);
            s++;
        }
        return profit;
    }
}
