class Solution {
    public int findMin(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (nums[min] > nums[max]) {
            min++;
        }
        return nums[min];
    }
}
