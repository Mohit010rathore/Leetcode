class Solution {
    public void func(int i , int n,int k, List<Integer> subSet , List<List<Integer>> ans ){
        
        // If i becomes greater than n, we should stop going forward
        if(i > n){
             // If k is equal to 0, we have generated a Valid Subset of K length
            if(k==0){
                ans.add(new ArrayList(subSet));
            }
            return ;
        }
        
        // If we don't have enough elements to make our subset, we shouldn't proceed further
        if (k > n - i + 1)
            return;
        
        //take the ith ele
        subSet.add(i);
        func(i+1,n,k-1,subSet,ans);
        
        //not take
        subSet.remove(subSet.size()-1);
        func(i+1,n,k,subSet,ans);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>>  ans = new ArrayList<>();
        
        
        func(1,n,k,subSet,ans);
        return ans;
    }
}