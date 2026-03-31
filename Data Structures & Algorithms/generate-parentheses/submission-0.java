class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder stack = new StringBuilder();
        List<String> res = new ArrayList<String>();
        backtrack(res, stack, 0, 0, n);
        return res;
    }

    private void backtrack(List<String> list, StringBuilder string, int openN, int closeN, int n) {
        if (openN == closeN && openN == n) {
            list.add(string.toString());
            return;
        }
        if (openN < n) {
            string.append('(');
            backtrack(list, string, openN + 1, closeN, n);
            string.deleteCharAt(string.length() - 1);
        }
        if (closeN < openN) {
            string.append(')');
            backtrack(list, string, openN, closeN + 1, n);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
