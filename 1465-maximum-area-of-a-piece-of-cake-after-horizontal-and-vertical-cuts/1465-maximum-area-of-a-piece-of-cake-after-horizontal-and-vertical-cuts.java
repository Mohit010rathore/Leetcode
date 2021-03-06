class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
       Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHeight = horizontalCuts[0];
        
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length-1]);
        for (int i = 1;i<horizontalCuts.length; i++){
            int horizatalWidth = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, horizatalWidth);
        }
        
        int maxWidth = verticalCuts[0];
        
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length-1]);
        for (int i = 1;i<verticalCuts.length; i++){
            int verticalWidth = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth, verticalWidth);
        }

        long ans = ((1L * maxHeight * maxWidth) % 1000000007); //use the 10^9+7 mmodulo here only and not latter as if used later it will store the bogus answer already
                    //https://www.geeksforgeeks.org/modulo-1097-1000000007/ 
                    //read this

        return  (int) (ans);
        
    }
}