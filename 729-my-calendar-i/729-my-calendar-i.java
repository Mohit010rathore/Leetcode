class MyCalendar {
    Map<Integer,Integer> nm=new HashMap<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if(nm.size()==0)
        {
            nm.put(start,end);
            return true;
        }
        for(int i:nm.keySet())
        {
            if(Math.max(start,i)<Math.min(end,nm.get(i)))
            {
                return false;
            }
        }
        nm.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */