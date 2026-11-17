class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        our_set=set()
        for num in nums:
            if num in our_set:
                return True
            our_set.add(num)

        return False

        