/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                            
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
               
        int carry = 0;
        while(c1 != null || c2 != null || carry == 1){
            int sum = 0;
            
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            
            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
       
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}