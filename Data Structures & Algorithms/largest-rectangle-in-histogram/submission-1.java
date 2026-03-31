class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> ascStack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int rectIndex = i;

            while (!ascStack.isEmpty() && ascStack.peek()[0] > heights[i]) {
                int[] rect = ascStack.pop();
                int index = rect[1];
                int area = (i - index) * rect[0];
                maxArea = Math.max(area, maxArea);
                rectIndex = index;
            }

            ascStack.push(new int[] {heights[i], rectIndex});
        }

        for (int[] rect: ascStack) {
            int area = (heights.length - rect[1]) * rect[0];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
