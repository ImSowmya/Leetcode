public class MaximumCountofPositiveIntegerAndNegativeInteger_2529
{
    // Returns the index of the last negative number,
    // or -1 if there are no negative numbers.
    public int NegCountSearch(int start, int end, int [] nums)
    {
        if (start > end)
        {
            return end; // If none found, end will be -1
        }
        
        int mid = start + (end - start) / 2;
        
        if (nums[mid] < 0)
        {
            // Check if it's the last negative:
            if (mid == nums.length - 1 || nums[mid + 1] >= 0)
            {
                return mid;
            }
            else
            {
                return NegCountSearch(mid + 1, end, nums);
            }
        }
        else
        {
            return NegCountSearch(start, mid - 1, nums);
        }
    }

    // Returns the index of the first positive number,
    // or nums.length if there are no positive numbers.
    public int PosCountSearch(int start, int end, int [] nums)
    {
        if (start > end)
        {
            return start; // If none found, start will be nums.length
        }
        
        int mid = start + (end - start) / 2;
        
        if (nums[mid] > 0)
        {
            // Check if it's the first positive:
            if (mid == 0 || nums[mid - 1] <= 0)
            {
                return mid;
            }
            else
            {
                return PosCountSearch(start, mid - 1, nums);
            }
        }
        else
        {
            return PosCountSearch(mid + 1, end, nums);
        }
    }

    public int maximumCount(int[] nums) 
    {
        int lastNeg = NegCountSearch(0, nums.length - 1, nums);
        int firstPos = PosCountSearch(0, nums.length - 1, nums);

        int countNeg = (lastNeg == -1) ? 0 : lastNeg + 1;
        int countPos = (firstPos == nums.length) ? 0 : nums.length - firstPos;

        System.out.println("Last negative index: " + lastNeg + ", Count of negatives: " + countNeg);
        System.out.println("First positive index: " + firstPos + ", Count of positives: " + countPos);

        return Math.max(countNeg, countPos);
    }

    public static void main(String[] args) {
        MaximumCountofPositiveIntegerAndNegativeInteger_2529 solution = new MaximumCountofPositiveIntegerAndNegativeInteger_2529();
        int[] nums = {-1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("Maximum count: " + solution.maximumCount(nums));
    }

}
