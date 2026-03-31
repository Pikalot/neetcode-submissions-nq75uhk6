class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        for (String s: tokens) {
            if (!operators.contains(s)) {
                int val = Integer.parseInt(s);
                stack.push(val);
            }
            else {
                int second = stack.pop();
                int first = stack.pop();
                if (s.equals("+")) {
                    stack.push(first + second);
                    System.out.println(stack);
                }
                if (s.equals("-")) {
                    stack.push(first - second);
                }
                if (s.equals("*")) {
                    stack.push(first * second);
                }
                if (s.equals("/")) {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
}
