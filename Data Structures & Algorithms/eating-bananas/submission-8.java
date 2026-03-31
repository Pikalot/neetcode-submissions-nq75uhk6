class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        for (int p: piles) {
            k = Math.max(k, p);
        }

        int l = 0, r = k - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int hour = 0;
            for (int p: piles) {
                hour += Math.ceil((double) p / m);
            }

            if (hour <= h) {
                k = Math.min(k, m);
                r = m - 1;
            }
            else l = m + 1;
        }    
        return k;
    }
}
