class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            System.out.println(l + " " + m + " " + r);
            if (nums[m] <= nums[r]) r = m;
            else l = m + 1;
        }

        return nums[l];
    }
}
