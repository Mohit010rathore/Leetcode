class Solution {
     public void recurPermutation(int[] nums,List<Integer> ds, List<List<Integer>> ans,boolean[]freq ){
        
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i-1] == nums[i] && freq[i-1]){
                continue;
            }
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recurPermutation(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        Arrays.sort(nums);
        recurPermutation(nums,ds,ans,freq);
        return ans;
    }
}