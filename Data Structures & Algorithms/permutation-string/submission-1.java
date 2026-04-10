class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26], count2 = new int[26];
        int matches = 0, l = 0;

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int rIndex = s2.charAt(r) - 'a';
            count2[rIndex]++;
            if (count1[rIndex] == count2[rIndex]) matches++;
            else if (count1[rIndex] == count2[rIndex] - 1) matches--;

            int lChar = s2.charAt(l) - 'a';
            count2[lChar]--;
            if (count1[lChar] == count2[lChar]) matches++;
            else if (count1[lChar] == count2[lChar] + 1) matches--;

            l++;
        }
        return matches == 26;
    }
}
