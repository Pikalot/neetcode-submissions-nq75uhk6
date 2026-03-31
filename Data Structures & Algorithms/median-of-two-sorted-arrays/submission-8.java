class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsShort = nums1, numsLong = nums2;
        int totalLength = nums1.length + nums2.length;
        int halfLength = (totalLength + 1) / 2;

        if (numsShort.length > numsLong.length) {
            numsShort = nums2;
            numsLong = nums1;
        }

        int l = 0, r = numsShort.length;
        while (l <= r) {
            int shortMid = (l + r) / 2;
            int leftIndex = halfLength - shortMid;

            int shortLeft = shortMid > 0 ? numsShort[shortMid - 1] : Integer.MIN_VALUE;
            int longLeft = leftIndex > 0 ? numsLong[leftIndex - 1] : Integer.MIN_VALUE;
            int shortRight = shortMid < numsShort.length ? numsShort[shortMid] : Integer.MAX_VALUE;
            int longRight = leftIndex < numsLong.length ? numsLong[leftIndex] : Integer.MAX_VALUE;
            // System.out.println(shortLeft + " " + shortRight);
            // System.out.println(longLeft + " " + longRight);
            // Found
            if (shortLeft <= longRight && longLeft <= shortRight) {
                // System.out.println("found");
                if (totalLength % 2 == 0) {
                    return (Math.max(shortLeft, longLeft) + Math.min(shortRight, longRight)) / 2.0;
                }
                return Math.max(shortLeft, longLeft);
            }
            
            if (shortRight > longLeft) r = shortMid - 1;
            else l = shortMid + 1;
        }

        return -1;
    }
}
