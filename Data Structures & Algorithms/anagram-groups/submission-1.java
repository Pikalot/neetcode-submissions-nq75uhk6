class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] count = countChar(str);
            String key = new String(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList(map.values());
    }

    private static char[] countChar(String s) {
        char[] res = new char[26];

        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }

        return res;
    }
}
