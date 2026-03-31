class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        int trapWater = 0;

        while (l < r) {
            int minH = Math.min(maxL, maxR); // Highest water can be contained
            int water = minH;

            // Check changes from smaller walls
            if (height[l] <= height[r]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                water = minH - height[l];
            }
            else {
                r--;
                maxR = Math.max(maxR, height[r]);
                water = minH - height[r];
            }

            if (water > 0) trapWater += water;
        }    
        return trapWater;
    }
}
