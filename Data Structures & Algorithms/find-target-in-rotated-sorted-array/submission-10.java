class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int i = searchMin(nums);

        if (nums[i] == target) return i;

        if (target > nums[r]) r = i;
        else l = i;

        while (l <= r) {
            int m = (l + r) / 2;
            System.out.println(nums[l] + " " + nums[m] + " " + nums[r]);
            if (nums[m] == target) return m;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    private int searchMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= nums[r]) l = m + 1;
            else r = m;
        }
        return l;
    }
}
