/**
s       O   U   Z   O   D   Y   X   A   Z   V
                l
                                        r
T       X   Y   Z
map     
count   0   ... 25

*/

class Solution {
    public String minWindow(String s, String t) {
        if (t == "") return "";
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        int l = 0, have = 0;

        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if (count.containsKey(c) && count.get(c).equals(map.get(c))) have++;

            while (have == count.size()) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (count.containsKey(leftChar) && map.get(leftChar) < count.get(leftChar)) have--;
                l++;
            }
        }

        return min < Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
