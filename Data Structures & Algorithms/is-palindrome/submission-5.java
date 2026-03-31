class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        String z = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int l = 0, r = z.length() - 1;
        while (l < r) {
            if (z.charAt(l) != z.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
