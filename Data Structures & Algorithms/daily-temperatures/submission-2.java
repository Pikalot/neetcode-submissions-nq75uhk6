class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> descStack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!descStack.isEmpty() && descStack.peek()[0] < temperatures[i]) {
                int[] temp = descStack.pop();
                result[temp[1]] = i - temp[1];
            }
            descStack.push(new int[] {temperatures[i], i});
        }

        return result;
    }
}
