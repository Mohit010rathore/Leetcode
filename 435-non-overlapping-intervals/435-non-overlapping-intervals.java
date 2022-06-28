class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        int count= 0;
        int n = intervals.length;
        int left = 0;
        int right = 1;
        
        while(right < n){
            if(intervals[left][1] <= intervals[right][0]){
                left = right;
                right += 1;
            }else if(intervals[left][1] <= intervals[right][1]){
                count+= 1;
                right += 1;
            }else if(intervals[left][1] > intervals[right][1]){
                count += 1;
                left = right;
                right += 1;
            }
        }
        return count;
        
    }
}