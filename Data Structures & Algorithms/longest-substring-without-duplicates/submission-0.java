class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        
        StringBuilder sub = new StringBuilder();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = 0;
            while (sub.indexOf(s.charAt(i) + "") != -1) {
                sub.deleteCharAt(0);
            }
            sub.append(s.charAt(i));
            maxLength = Math.max(maxLength, sub.length());
        }

        return maxLength;
    }
}
