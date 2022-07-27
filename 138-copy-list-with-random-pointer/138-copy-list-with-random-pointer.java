/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
//         Node curr = head, temp = head;
        
//         // Step 1: Insert copy nodes right after original nodes
//         while(curr != null){
//             temp = curr.next; 
//             curr.next = new Node(curr.val);
//             curr.next.next = temp;
//             curr = temp;
//         }
        
//         // Step 2: Point the random pointers
//         curr = head;
//         while(curr != null){
//             if(curr.random != null)
//                 curr.next.random = curr.random.next;
//             curr = curr.next.next;
//         }
        
//         // Step 3: Get the original and deep copy linked list
//         curr = head;
//         Node copyHead = new Node(0);
//         Node copy = copyHead;
        
//         while(curr != null){
//             temp = curr.next.next;
//             copy.next = curr.next;
//             curr.next = temp;
//             copy = copy.next;
//             curr = curr.next;
//         }
        
//         return copyHead.next;
        if(head==null) return head;
        Node curr = head, temp = null;
 
        // insert additional node after
        // every node of original list
        while (curr != null) {
            temp = curr.next;
 
            // Inserting node
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
 
        // adjust the random pointers of the
        // newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null)
                                       ? curr.random.next
                                       : curr.random;
 
            // move to the next newly added node by
            // skipping an original node
            curr = curr.next.next;                   
        }
 
        Node original = head, copy = head.next;
 
        // save the start of copied linked list
        temp = copy;
 
        // now separate the original list and copied list
        while (original != null) {
            original.next =original.next.next;
 
          copy.next = (copy.next != null) ? copy.next.next
                                            : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
        
    }
}