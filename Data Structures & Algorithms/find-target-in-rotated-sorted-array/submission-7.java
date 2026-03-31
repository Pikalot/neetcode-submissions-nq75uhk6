class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int minIndex = binSearchMin(nums);

        if (target <= nums[right]) {
            left = minIndex;
        }
        else {right = minIndex - 1;}

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(nums[left] + " " + nums[mid] + " " + nums[right]);

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {left = mid + 1;}
            else right = mid - 1;
        }

        return -1;
    }

    private static int binSearchMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
