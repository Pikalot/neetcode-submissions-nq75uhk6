class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxF = 0, maxL = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts[c - 'A']++;
            maxF = Math.max(maxF, counts[c - 'A']);

            while ((r - l + 1) - maxF > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            maxL = Math.max(maxL, r - l + 1);
        }

        return maxL;
    }
}
