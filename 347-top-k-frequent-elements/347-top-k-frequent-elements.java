class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int el : nums){
            map.put(el, map.getOrDefault(el,0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[1] - b[1]));
        
        //adding all the elements in priorityQueue from the map
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int [] ans = new int[k];
        
        while(k > 0){
            ans[k-1] = pq.poll()[0];
            k--;
        }
        return ans;
    }
}