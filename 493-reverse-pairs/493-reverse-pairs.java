class Solution {

     public int reversePairs(int[] nums) {
        int n = nums.length; // n is the length of the array
        return mergeSort(nums,0,n-1); // calling the merge sort function to sort the array
    }

    private int mergeSort(int[]nums,int strtIdx, int endIdx){

        if (strtIdx>=endIdx){//if zero elements in the array or one element in the array
            return 0;
        }
        int count = 0; //count is the number of pairs of elements in the array
        int mid = strtIdx + (endIdx - strtIdx)/2; //mid is the mid-point of the array


        //start index to mid index means left subarray and mid+1 to end index means right subarray

        count +=mergeSort(nums,strtIdx,mid); //count pairs and recursively call the merge sort function to sort the left subarray
        count +=mergeSort(nums,mid+1,endIdx);//count pairs and recursively call the merge sort function to sort the right subarray
        count +=merge(nums,strtIdx,mid,endIdx);//count pairs and recursively call the merge function to sort the left subarray and right subarray
        return count;//return the number of pairs of elements in the array
    }

    
    int merge(int[] nums, int low, int mid, int high){
        int cnt =0, j =mid + 1;
        
        for(int i=low; i<=mid; i++){ // Left half of array
            while(j<=high && nums[i] > (2*(long)nums[j])){ // exausted condition
                j++;
            }
            cnt += (j - (mid + 1)); // No.of left elements
        }
        
        ArrayList<Integer> temp = new ArrayList();
        
        int left = low, right = mid + 1;
        while(left <= mid && right <= high){
            // Condition goes for Smaller Case
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }
        
        // If any one of L/R is Exausted
        while(left <= mid){
            temp.add(nums[left++]);
        }
        while(right <= high){
            temp.add(nums[right++]);
        }
              
        // Copyong back to the Original Array
        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i - low);
        }
        // Merge Step Is Done!!
        return cnt; // Now, returning back the Total no.of pairs
    }
}