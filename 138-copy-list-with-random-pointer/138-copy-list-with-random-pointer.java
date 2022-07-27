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
        Node curr = head, temp = head;
        
        // Step 1: Insert copy nodes right after original nodes
        while(curr != null){
            temp = curr.next; 
            // Node copy = new Node(curr.val);
            // curr.next = copy;
            // copy.next = temp;
            // curr = temp;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        
        // Step 2: Point the random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        // Step 3: Get the original and deep copy linked list
        curr = head;
        Node copyHead = new Node(0);
        Node copy = copyHead;
        
        while(curr != null){
            temp = curr.next.next;
            copy.next = curr.next;
            curr.next = temp;
            copy = copy.next;
            curr = curr.next;
        }
        
        return copyHead.next;
        
    }
}