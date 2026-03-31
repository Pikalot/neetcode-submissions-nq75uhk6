class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int left = 0, right = 0, i = 0;
        
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] <= nums2[right]) nums[i++] = nums1[left++];
            else nums[i++] = nums2[right++];
        }
        
        while (left < nums1.length) {
            nums[i++] = nums1[left++];
        }

        while (right < nums2.length) {
            nums[i++] = nums2[right++];
        }


        for (int n: nums) {System.out.println(n);}
        int midL = (nums.length - 1) / 2;
        int midR = nums.length % 2 == 0 ? midL + 1: midL;
        return (double) (nums[midL] + nums[midR]) / 2;
    }
}
