class Solution {
    public int leastInterval(char[] tasks, int n) {
        //frequencies of the tasks
        int [] frequencies = new int[26];
        for(char it : tasks){
            frequencies[it - 'A']++;
        }
        
        Arrays.sort(frequencies);
        
        //max Frequency
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;
        
        //reducing the idle spots
        for(int i = frequencies.length - 2;i>= 0 && idle_time>0;i--){
            idle_time -= Math.min(f_max -1 , frequencies[i]);
        }
        idle_time = Math.max(0,idle_time);
        
        return idle_time  + tasks.length;
    }
}