class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] s = nums1, l = nums2;
        int totalLength = nums1.length + nums2.length;
        int halfLength = (totalLength + 1) / 2;

        if (nums1.length > nums2.length) {
            s = nums2;
            l = nums1;
        }

        int left = 0, right = s.length;

        while (left <= right) {
            int sMid = (left + right) / 2;
            int lIndex = halfLength - sMid;

            int sLeft = sMid > 0 ? s[sMid - 1] : Integer.MIN_VALUE;
            int sRight = sMid < s.length ? s[sMid] : Integer.MAX_VALUE;
            int lLeft = lIndex > 0 ? l[lIndex - 1] : Integer.MIN_VALUE;
            int lRight = lIndex < l.length ? l[lIndex] : Integer.MAX_VALUE;

            // System.out.println(sLeft + " " + sRight +'\n' + lLeft + " " + lRight);
            if (sLeft <= lRight && lLeft <= sRight) {
                if (totalLength % 2 == 0) {
                    return (Math.max(sLeft, lLeft) + Math.min(sRight, lRight)) / 2.0;
                }
                return Math.max(sLeft, lLeft);
            }
            if (sRight < lLeft) {
                left = sMid + 1;
            }
            else right = sMid - 1;
        }

        return -1;
    }
}
