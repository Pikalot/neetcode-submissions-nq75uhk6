class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            // right wing is sorted
            if (nums[m] < nums[r]) {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
            // left wing is sorted
            else {
                if (nums[m] > target && target >= nums[l]) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }
}
