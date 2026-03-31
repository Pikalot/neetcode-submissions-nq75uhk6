class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> recStack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int newRecIndex = i;
            while (!recStack.isEmpty() && recStack.peek()[1] > heights[i]) {
                // Calculate max area of removed rectangles
                int[] rec = recStack.pop();
                int height = rec[1];
                int index = rec[0];
                maxArea = Math.max(maxArea, height * (i - index));
                newRecIndex = index;
            }
            recStack.push(new int[] {newRecIndex, heights[i]});
        }

        // Calculate max area in the stack
        for (int[] rec: recStack) {
            int index = rec[0];
            int height = rec[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
