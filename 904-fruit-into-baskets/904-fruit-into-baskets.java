class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0){
            return 0;
        }
        
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i = 0;
        int j = 0;
        
        while(j < fruits.length){
            //we will only consider only two fruits occurences
            if(map.size() <= 2){
                //if already present the j value will be overriden
                map.put(fruits[j],j++);
            }
            
            //if the size goes beyond 2,it is wrong case
            //we move to the place where we first seen the first fruit leftmost occurence store in  min
            //we go there and delete that min val
            if(map.size() > 2){
                int min = fruits.length - 1;
                for(int value : map.values()){
                    min = Math.min(min,value);
                }
                
                i = min + 1;
                map.remove(fruits[min]);
            }
            max = Math.max(max,j-i);
        }
        
        return max;
    }
}