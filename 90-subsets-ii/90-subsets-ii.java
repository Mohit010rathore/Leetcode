class Solution {
    public void func(int ind,int []nums,ArrayList<Integer> ds, List<List<Integer>> subList){
        subList.add(new ArrayList<>(ds));
        for(int i = ind;i< nums.length;i++){
            if(i != ind && nums[i] == nums[i-1])continue;
            
            ds.add(nums[i]);
            func(i+1,nums,ds,subList);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subList = new ArrayList<>();
        func(0,nums,new ArrayList<>(),subList);
        return subList;
    }
}