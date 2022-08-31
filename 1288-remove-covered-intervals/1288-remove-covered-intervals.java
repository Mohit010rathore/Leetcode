class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[0] == b[0] ? b[1]-a[1]: a[0]-b[0]));
        
        int ans = 0;
        int prevRange = -1;
        
        for(int [] interval : intervals){
            if(prevRange >= interval[1]){
                ans++;
            }
            prevRange = Math.max(interval[1],prevRange);
        }
        
        return intervals.length - ans;
    }
}