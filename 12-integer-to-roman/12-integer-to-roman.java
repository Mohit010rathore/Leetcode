class Solution {
    public String intToRoman(int num) {
        
        //we need something to map these characters
        //so we take 2 arrays-> one to store integers and other one to store characters
        String[] characters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<nums.length;i++){
            while(num >= nums[i]){
                ans.append(characters[i]);
                num -= nums[i];  //reducing the value of num to find other romans
            }
        }
        return ans.toString();
        
    }
}