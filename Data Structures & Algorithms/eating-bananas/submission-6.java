class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Mininum rate is 1 banana per hour, maximum rate is the banana of the largest pile
        // Apply binary search to test any possible rate that less than given h
        // Find the minimum rate if possible

        // Find bananas in the largest pile
        int max = 0;
        for (int b: piles) {
            max = Math.max(max, b);
        }

        // Largest k is the largest bananas
        int result = max;

        // Binary search to test if any other rate can qualify
        int l = 0;
        int r = max - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            // Find total hours to eat up all piles
            int hour = 0;
            for (int b: piles) {
                hour += Math.ceil((double) b/m);
            }

            // Find every possible smaller k
            if (hour <= h) {
                r = m - 1;
                // Update the min rate
                result = Math.min(result, m);
            }
            else l = m + 1;
        }
        
        return result;
    }
}
