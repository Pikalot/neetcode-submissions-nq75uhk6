class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        int slow2 = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);
        return slow2;
    }
}
