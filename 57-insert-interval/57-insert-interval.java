class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new LinkedList<>();
        int i =0;
        int len = intervals.length;
        
        //no overlapping ->we move ahead(safe intervals before merging)
        while(i < len && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        
        //merging part
        while( i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]); //new interval start
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); //new interval end
            i++;
        }
        
        ans.add(newInterval);
        
        //adding those whose no overlapping condn is there
        while(i < len){
            ans.add(intervals[i]);
            i++;
        }
        
        int[][] result = new int[ans.size()][2];
        int j = 0;
        while(j < ans.size()){
            result[j] = ans.get(j);
            j++;
        }
        return result;
    }
}