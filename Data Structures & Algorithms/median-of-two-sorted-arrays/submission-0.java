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
        // System.out.println(midL + " " + midR);
        return (double) (nums[midL] + nums[midR]) / 2;
    }

    private static int searchLeft(int[] arr) {
        int l = 0, r = arr.length - 1, ans = arr[l], target = arr[(l + r) / 2];
        System.out.println("mid " + target);
        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] == target) return arr[m];
            else if (arr[m] < target) {
                l = m;
            }
            else r = m - 1;
        }
        return l;
    }

     private static int searchRight(int[] arr) {
        int l = 0, r = arr.length - 1, ans = arr[r], target = (arr[l] + arr[r]) / 2;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] == target) return arr[m];
            else if (arr[m] < target) l = m + 1;
            else {
                ans = arr[r];
                r = m;
            }
        }
        return ans;
    }
}
