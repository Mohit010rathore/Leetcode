class Solution 
{
    public int getMaxLen(int[] nums) 
    {
        // O(n) time | O(1) space
        int positive = 0, negative = 0;
        int max = 0;
        
        for(int n : nums)
        {
            if(n == 0)
            {
                positive = 0;
                negative = 0;
            }
            else if(n > 0)
            {
                positive += 1;
                negative = negative == 0 ? 0 : negative+1;
            }
            else
            {
                // swap positive and negative
                int tmp = positive;
                positive = negative == 0 ? 0 : negative+1;
                negative = tmp+1;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}