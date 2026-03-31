class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            int area = minHeight * (r - l);
            maxArea = Math.max(maxArea, area);

            while (l < r && heights[l] <= minHeight) l++;
            while (l < r && heights[r] <= minHeight) r--;
        }
        return maxArea;
    }
}
