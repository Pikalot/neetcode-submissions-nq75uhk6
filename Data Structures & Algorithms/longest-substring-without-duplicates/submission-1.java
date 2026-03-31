class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        
        Set<Character> sub = new HashSet<>();
        int maxLength = 0, l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (sub.contains(c)) {
                sub.remove(s.charAt(l++));
            }
            sub.add(c);
            maxLength = Math.max(maxLength, sub.size());
        }

        return maxLength;
    }
}
