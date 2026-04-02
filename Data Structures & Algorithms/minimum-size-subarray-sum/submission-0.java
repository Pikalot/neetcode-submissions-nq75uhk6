// arr  2   1   5   1   5   3   | target = 10
//              l
//                      r
// sum  11
// l    3
// minL 3

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0;
        int minL = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minL = Math.min(minL, r - l + 1);
                sum -= nums[l++];
            }
        }

        return minL != Integer.MAX_VALUE ? minL : 0;
    }
}