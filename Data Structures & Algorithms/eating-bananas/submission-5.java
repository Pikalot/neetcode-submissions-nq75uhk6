class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n: piles) {
            max = Math.max(max, n);
        }
        int result = max;

        int l = 1;
        int r = max - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int hour = 0;
            for (int p: piles) {
                hour += Math.ceil((double) p/m);
            }
            if (hour <= h) {
                result = Math.min(result, m);
                r = m - 1;
            }
            else l = m + 1;
        }

        return result;
    }
}
