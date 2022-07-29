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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        
        ListNode curr = dummy;
        ListNode nex = dummy;
        ListNode pre = dummy;
        
        int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        
        //the main thing
        while(count >= k){
            curr = pre.next; //we have to make sure curr is standing at the first node of k group
            nex = curr.next; //and nex is standing at the 2nd node of the group
            
            for(int i= 1;i < k;i++){ //now we reverse k-1 links
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dummy.next;
    }
}