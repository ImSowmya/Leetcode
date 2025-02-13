import heapq 

class Solution(object):
    def minOperations(self, nums, k):
        heapq.heapify(nums)
        num_operations = 0
        while nums[0] < k:
            x = heapq.heappop(nums)
            y = heapq.heappop(nums)
            heapq.heappush(nums,min(x,y)*2+max(x,y))
            num_operations+=1
        return num_operations
    
nums = [2,11,10,1,3]
k = 10
min_ops = Solution()
print(min_ops.minOperations(nums, k))