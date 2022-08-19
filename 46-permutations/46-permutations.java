class Solution {
    
//     public void recurPermutation(int[] nums,List<Integer> ds, List<List<Integer>> ans ,boolean freq[] ){
        
//         if(ds.size() == nums.length){
//             ans.add(new ArrayList<>(ds));
//             return ;
//         }
        
//         for(int i = 0;i < nums.length;i++){
//             if(!freq[i]){
//                 freq[i] = true;
//                 ds.add(nums[i]);
//                 recurPermutation(nums,ds,ans,freq);
//                 ds.remove(ds.size()-1);
//                 freq[i] = false;
//             }
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         boolean freq[] = new boolean[nums.length];
        
//         recurPermutation(nums,ds,ans,freq);
//         return ans;
        
//     }
    
    //Swap method
    private void recurPermutate(int index,int []nums,List<List<Integer>> ans){
        
        if(index == nums.length){
            //copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i = 0;i < nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i = index;i < nums.length;i++){
            swap(i,index,nums);
            recurPermutate(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    private void swap(int i,int j , int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermutate(0,nums,ans);
        return ans;
    }
}