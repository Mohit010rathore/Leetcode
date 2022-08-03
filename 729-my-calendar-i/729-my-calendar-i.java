/* Approach: 
~ There are plenty of ways in which bookings can overlap, but there are essentially only two ways in which they'd not :
    either startTwo >= endOne or startOne >= endTwo (end being exclusive).
    now if any of these is met it's true otherwise false.
*/

class MyCalendar {
    List<int[]> bookings;
    
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
        for(int[] a : bookings){
            if(!(a[0] >= end || start >= a[1]))
                return false;
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
}