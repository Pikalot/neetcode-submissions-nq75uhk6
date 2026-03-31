class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, index = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        do {
            slow = nums[slow];
            index = nums[index];
        } while (index != slow);

        return slow;
    }
}
