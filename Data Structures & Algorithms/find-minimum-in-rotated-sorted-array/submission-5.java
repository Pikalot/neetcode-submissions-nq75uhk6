class Solution {
    public int findMin(int[] nums) {
        // Use binary search
        // If nums[mid] < nums[right], mid is in range of smaller sequence
        // If nums[mid] >= nums[right], out range, move left to right of mid
        int left = 0;
        int right = nums.length - 1;

        // when left == right => found
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else left = mid + 1;
        }

        return nums[left];
    }
}
