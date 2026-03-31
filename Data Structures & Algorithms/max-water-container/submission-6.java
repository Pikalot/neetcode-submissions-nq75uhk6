class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);

            while (left < right && heights[left] <= minHeight) {
                left++;
            }

            while (left < right && heights[right] <= minHeight) {
                right--;
            }
        }

        return maxArea;
    }
}
