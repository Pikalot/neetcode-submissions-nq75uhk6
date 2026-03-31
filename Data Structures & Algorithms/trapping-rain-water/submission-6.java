class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        int trapWater = 0;

        while (l < r) {
            int minH = Math.min(maxL, maxR);
            int water = 0;
            if (height[l] <= height[r]) {
                l++;
                water = minH - height[l];
                maxL = Math.max(maxL, height[l]);
            }
            else {
                r--;
                water = minH - height[r];
                maxR = Math.max(maxR, height[r]);
            }

            if (water > 0) {
                trapWater += water;
            }
        }

        return trapWater;
    }
}
