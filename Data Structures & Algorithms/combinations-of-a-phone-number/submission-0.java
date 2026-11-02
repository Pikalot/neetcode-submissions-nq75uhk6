/**
    3   4
    i
    
    d           e           
    4:f g   i   f   g   i


map 3:def, 4: fgi
path
list


*/


class Solution {
    String[] sMap = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> list, String digits, int i, StringBuilder path) {
        if (i == digits.length()) {
            list.add(path.toString());
            return;
        }
       
        String st = sMap[digits.charAt(i) - '1'];
        for (int j = 0; j < st.length(); j++) {
            path.append(st.charAt(j));
            backtrack(list, digits, i + 1, path);
            path.setLength(path.length() - 1);
        }
    }
}
