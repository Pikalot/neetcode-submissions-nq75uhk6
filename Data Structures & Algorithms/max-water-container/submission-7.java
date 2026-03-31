class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            int area = (right - left) * minHeight;
            maxArea = Math.max(area, maxArea);

            if (left < right && heights[left] <= heights[right]) {
                left++;
            }
            else if (left < right && heights[left] >= heights[right]) {
                right--;
            }
        }    
        return maxArea;
    }
}
