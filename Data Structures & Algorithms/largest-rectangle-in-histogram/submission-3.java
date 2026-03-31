class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> ascStack = new Stack<>(); // {index, height}

        for (int i = 0; i < heights.length; i++) {
            int anchorIndex = i;
            while (!ascStack.isEmpty() && ascStack.peek()[1] >= heights[i]) {
                int[] rect = ascStack.pop();
                anchorIndex = rect[0];
                int area = (i - rect[0]) * rect[1];
                maxArea = Math.max(area, maxArea);
            }
            ascStack.push(new int[] {anchorIndex, heights[i]});
        }
        
        while (!ascStack.isEmpty()) {
            int rect[] = ascStack.pop();
            int area = (heights.length - rect[0]) * rect[1];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
