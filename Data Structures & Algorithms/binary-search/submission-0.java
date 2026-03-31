class Solution {
    public int search(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    private static int binSearch(int[] arr, int l, int r, int target) {
        int mid = (l + r) / 2;

        if (arr[mid] == target) return mid;
        if (l < r && arr[mid] < target) return binSearch(arr, mid + 1, r, target);
        if (l < r && arr[mid] > target) return binSearch(arr, l, mid - 1, target);
        return -1;
    }
}
