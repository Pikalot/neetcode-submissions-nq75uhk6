class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sArray = nums1, lArray = nums2;
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (nums1.length > nums2.length) {
            sArray = nums2;
            lArray = nums1;
        }

        int left = 0, right = sArray.length;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            int sLeft = i > 0 ? sArray[i - 1] : Integer.MIN_VALUE;
            int sRight = i < sArray.length ? sArray[i] : Integer.MAX_VALUE;
            int lLeft = j > 0 ? lArray[j - 1] : Integer.MIN_VALUE;
            int lRight = j < lArray.length ? lArray[j] : Integer.MAX_VALUE;

            if (sLeft <= lRight && lLeft <= sRight) {
                if (total % 2 != 0) {
                    return Math.max(sLeft, lLeft);
                }
                return (Math.max(sLeft, lLeft) + Math.min(sRight, lRight)) / 2.0;
            }
            else if (sLeft > lRight) {
                right = i - 1;
            }
            else left = i + 1;
        }
        return -1;
    }
}
