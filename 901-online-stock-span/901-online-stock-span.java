class StockSpanner {

    Stack<int[]>s;
    public StockSpanner() {
        s = new Stack<int[]>();
    }
    
   public int next(int price) {             
     int span=1;                               // intial span set to 1-> and also to count how many times u pop  for each input and + 1 which is intial value.//

   while(!s.isEmpty() && s.peek()[1]<=price){   //checking condition stack peek value is greater than input and peek() is 1 because in the below { span,price}->{0,1}.
     span+=s.pop()[0];                                    //  popping only when the value is greater than peek means input is high.
    }
    
    s.push(new int[] {span,price });             //if input is less than stack peek ...we just push input with span value 1.
    return span;                          //we return span at the end which we collected each input span...
	                                      // note for every input we save span value and while popping add the same value to 1(already intialised).
   
    
}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */