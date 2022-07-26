/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        
        //if a and b have different len,then we will stop the loop after second iteration
        while(curr1 != curr2){
            //for the end of first iteration , we just reset the pointer to the head of another linked list
            
            if(curr1 == null){
                curr1 = headB;
            }else{
                curr1 = curr1.next;
            }
            if(curr2 == null){
                curr2 = headA;
            }else{
                curr2 = curr2.next;
            }
        }
        return curr1;
        
    }
}