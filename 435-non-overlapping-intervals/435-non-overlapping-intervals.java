class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sorting all the intervals in the ascending orders
         Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        
        int count= 0; // count of no. of intervals to be removed
        int n = intervals.length; // number of intervals
        int left = 0; //left interval
        int right = 1; // right interval
        
        while(right < n){  //unless all intervals are compared
            if(intervals[left][1] <= intervals[right][0]){ //Non- overlapping case
                left = right;
                right += 1;
            }
            //Overlapping case 1(REmove right interval)
            else if(intervals[left][1] <= intervals[right][1]){
                count+= 1; // delete right
                right += 1;
            }
            //Overlapping case2- (Remove left interval)
            else if(intervals[left][1] > intervals[right][1]){
                count += 1;
                left = right;
                right += 1;
            }
        }
        return count;
        
    }
}