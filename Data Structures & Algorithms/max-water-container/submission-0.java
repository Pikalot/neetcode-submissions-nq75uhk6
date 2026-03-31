class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max((right - left) * minHeight, maxArea);
            if (heights[left] < heights[right]) {
                left++;
            }
            else right--;
        }

        return maxArea;
    }
}
