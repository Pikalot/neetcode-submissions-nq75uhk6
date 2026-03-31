class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            System.out.println(nums[l] + " " + nums[m] + " " + nums[r]);
            if (nums[m] == target) return m;

            if (nums[m] >= nums[l]) {
                // Left is sorted, search left
                System.out.println("search left");
                // Target must stay on the left wing
                if (nums[m] > target && target >= nums[l]) r = m - 1;
                else l = m + 1;
            }
            else {
                // Right is sorted, search right
                System.out.println("search right");
                // Target must stay on the right wing
                if (nums[m] < target && target < nums[l]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}
