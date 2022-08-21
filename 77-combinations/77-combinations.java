class Solution {
    public void func(int i , int n,int k, List<Integer> subSet , List<List<Integer>> ans ){
        
        if(i > n){
            if(k==0){
                ans.add(new ArrayList(subSet));
            }
            return ;
        }
        
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