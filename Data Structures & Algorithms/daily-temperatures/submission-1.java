class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> mapStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int val = temperatures[i];
            while (!mapStack.isEmpty() && mapStack.peek()[0] < val) {
                int prev = mapStack.pop()[1];
                result[prev] = i - prev;
            }
            mapStack.push(new int[] {val, i});
        }

        return result;
    }
}
