class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printSub(0, temp, nums, ans);
        return ans;
    }
    void printSub(int index, List<Integer> temp, int[] nums, List<List<Integer>> ans){
        // Base case
        if(index >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        // Pick element at index
        temp.add(nums[index]);
        printSub(index+1, temp, nums, ans);
        
        // Not Pick element at index
        // System.out.println(index);
        temp.remove(temp.size()-1); // Backtrack
        printSub(index+1, temp, nums, ans);
    }
}