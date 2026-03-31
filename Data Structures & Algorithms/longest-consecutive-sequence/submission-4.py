class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        max_length = 0
        num_set = set()
        for n in nums:
            num_set.add(n)

        for n in num_set:
            if n - 1 not in num_set:
                length = 0
                while n + length in num_set:
                    length += 1
                max_length = max(length, max_length)

        return max_length