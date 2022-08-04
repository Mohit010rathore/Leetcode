class MyStack {
    
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
	
    public void push(int x) {
        
      // Push x into q2
        q2.add(x);
        
        // Push all the elements of q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        
        //swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
    }
    
    public int pop() {
         return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}