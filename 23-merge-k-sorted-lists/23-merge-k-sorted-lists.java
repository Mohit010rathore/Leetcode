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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()){
            ListNode curr = queue.poll();
            temp.next = curr;
            temp = temp.next;
            
            if(curr.next != null){
                queue.add(curr.next);
            }
        }
        
        return head.next;
    }
}