class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(')');
            else if (chars[i] == '[') stack.push(']');
            else if (chars[i] == '{') stack.push('}');
            else if (stack.isEmpty() || chars[i] != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
}
