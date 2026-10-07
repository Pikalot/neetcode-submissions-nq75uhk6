class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) return "";

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int need = count.size(), have = 0, l = 0;
        int minL = Integer.MAX_VALUE;
        int[] res = new int[2];
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (count.containsKey(c) && count.get(c).equals(map.get(c))) have++;

            while (have == need) {
                char leftChar = s.charAt(l);
            
                if (r - l + 1 < minL) {
                    minL = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                map.put(leftChar, map.get(leftChar) - 1);

                if (count.containsKey(leftChar) && map.get(leftChar) < count.get(leftChar)) have--;
                l++;
            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
