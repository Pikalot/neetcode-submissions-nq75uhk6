class Solution {
    public int trap(int[] height) {
        int totalArea = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                int water = Math.min(maxLeft, maxRight) - height[left];
                if (water > 0) totalArea += water;
            }
            else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                int water = Math.min(maxLeft, maxRight) - height[right];
                if (water > 0) totalArea += water;
            }
        }

        return totalArea;
    }
}
