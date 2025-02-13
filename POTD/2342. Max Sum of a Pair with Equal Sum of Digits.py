"""
Approach
SORTING

Sorting the values and picking the largest ones.
However, in this case, we can't directly sort the elements. 
Instead, we need to map each number to its digit sum and then sort the numbers within each group that shares the same digit sum.

Complexity Analysis
The time complexity for this approach is O(NlogN) due to the sorting operation.
O(N) of Space complexity to store the digit sum of each number.
"""

class Solution(object):

    def calculate_digit_sum(self, num):
        digit_sum = 0
        while num:
            digit_sum+=num%10
            num//=10
        return digit_sum
        
    def maximumSum(self, nums):

        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = -1
        digit_sum_pairs = []
        for num in nums:
            digit_sum = self.calculate_digit_sum(num)
            digit_sum_pairs.append((digit_sum, num))
        digit_sum_pairs.sort()

        for index in range(1, len(digit_sum_pairs)):
            if digit_sum_pairs[index-1][0] == digit_sum_pairs[index][0]:
                current_sum = digit_sum_pairs[index-1][1] + digit_sum_pairs[index][1]
                max_sum = max(current_sum, max_sum)
        
        return max_sum       

ans = Solution()
print(ans.maximumSum([36, 60, 45, 18, 33, 24]))