class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Save each element appearance in a table
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //define min Heap with size K
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        //top k Frequent element
        for(int num: map.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int[] res = new int[minHeap.size()];
        int index = 0;
        while(minHeap.isEmpty() == false){
            res[index++] = minHeap.poll();
        }
        
        return res; 
    }
}

