class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, 0, new ArrayList<>());
        return res;    
    }

    private void backtrack(List<List<String>> list, String s, int i, List<String> path) {
        if (i == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String st = s.substring(i, j + 1);

            if (isPalind(st)) {
                path.add(st);
                backtrack(list, s, j + 1, path);
                path.removeLast();
            }
        }
    }

    private boolean isPalind(String st) {
        int s = 0, e = st.length() - 1;

        while (s < e) {
            if (st.charAt(s++) != st.charAt(e--)) return false;
        }
        return true;
    }
}
